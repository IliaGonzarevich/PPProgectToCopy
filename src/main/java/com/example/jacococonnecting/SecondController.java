package com.example.jacococonnecting;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.util.Objects;
import java.util.Random;

public class SecondController {

    @FXML
    private Label lblShow2;

    @FXML
    private Label variantlbl;

    @FXML
    private VBox radiovertical;

    @FXML
    private RadioButton radio1;

    @FXML
    private RadioButton radio2;

    @FXML
    private RadioButton radio3;

    @FXML
    private RadioButton radio4;

    @FXML
    private ToggleGroup radioGroup;

    @FXML
    private AnchorPane hideBottom;

    @FXML
    private VBox hideVB;

    @FXML
    private AnchorPane hideTop;

    @FXML
    private AnchorPane results;

    @FXML
    private Label resultlbl;

    @FXML
    private Separator sep;

    @FXML
    private Label lblShow;

    @FXML
    private Label lblA;

    @FXML
    private Label lblY;

    @FXML
    private Label lblN;

    @FXML
    private Label lblQ;

    @FXML
    private Label labelHideA;

    @FXML
    private ProgressBar pbar;


    Questions[] questions = new Questions[]{
            new Questions("матрица", "матрицей A размера m×n\nназывается прямоугольная таблица\nсодержащая m строк и n столбцов"),
            new Questions("матрица-строка (вектор-строка)", "матрица, содержащая одну строку,\nназывается матрицей-строкой\nили вектором-строкой."),
            new Questions("матрица-столбец (вектор-столбец)", "матрица, содержащая один столбец,\nназывается матрицей-столбцом\nили вектором-столбцом"),
            new Questions("4?", "4"),
            new Questions("5?", "5"),
            new Questions("6?", "6"),
            new Questions("7?", "7"),
            new Questions("8?", "8"),
            new Questions("9?", "9"),
            new Questions("10?", "10"),
            new Questions("11?", "11"),
            new Questions("12?", "12"),
            new Questions("13?", "13"),
            new Questions("14?", "14"),
            new Questions("15?", "15"),
            new Questions("16?", "16"),
            new Questions("17?", "17"),
            new Questions("18?", "18"),
            new Questions("19?", "19"),
            new Questions("20?", "20")
    };


    void changeBackground(Label lbl, String clr, String bckrad, String brad, String bwth) {
        lbl.setStyle("-fx-background-color: " + clr + "; -fx-background-radius: 0 0 " + bckrad + "; -fx-border-radius: 0 0 " + brad + "; -fx-border-color: grey; -fx-border-width: 1 1 1 " + bwth + ";");
    }

    private int num = questions.length;
    private int statistic = 0;
    private int n;


    Random random = new Random();

    void rand3() {
        String[] masN = new String[4];

        for (int i = 0; i<masN.length; i++){
            
            n = random.nextInt(num);


             masN[i]=questions[n].getAnswer();
        }

        int Num = 3;
        for (int i = 0; i<masN.length; i++) {
            int k = random.nextInt(4);
            String obmen = masN[k];
            masN[k] = masN[Num];
            masN[Num] = obmen;
            Num = k;
        }

        radio1.setText(masN[0]);
        radio2.setText(masN[1]);
        radio3.setText(masN[2]);
        radio4.setText(masN[3]);

        lblQ.setText(questions[n].getQuestion());
        lblA.setText(questions[n].getAnswer());
    }

    void rand2(){

        Questions x;
        x = questions[n];

        questions[n] = questions[num-1];

        questions[num-1] = x;
    }


    @FXML
    void initialize() {

        radiovertical.setVisible(false);

        lblShow2.setVisible(false);

        results.setVisible(false);

        labelHideA.setOnMouseEntered(event -> labelHideA.setText("Ответ: " + questions[n].getAnswer()));        //обработка наведения на подсказку "показать ответ"
        labelHideA.setOnMouseExited(event -> labelHideA.setText("Ну ладно, если прям не помнишь, посмотри уже"));

        lblY.setOnMouseEntered(event -> changeBackground(lblY, "green", "0 20", "0 20", "1"));       //обработка наведения на кнопку "я знаю"
        lblY.setOnMouseExited(event -> changeBackground(lblY, "white", "0 20", "0 20", "1"));

        lblN.setOnMouseEntered(event -> changeBackground(lblN, "grey", "20 0", "20 0", "0"));        //обработка наведения на кнопку "я не знаю"
        lblN.setOnMouseExited(event -> changeBackground(lblN, "white", "20 0", "20 0", "0"));

        if (!radiovertical.isVisible()) {
            System.out.println("Я в дефолте");
            rand3();

            lblA.setVisible(false);
            sep.setVisible(false);

            lblShow.setOnMousePressed(enent -> {
                sep.setVisible(true);
                lblShow.setVisible(false);
                lblA.setVisible(true);
                variantlbl.setVisible(false);
            });


            lblY.setOnMousePressed(event -> {

                rand2();
                num--;

                if (num == 0) {
                    hideVB.setVisible(false);
                    hideTop.setVisible(false);
                    hideBottom.setVisible(false);
                    results.setVisible(true);
                    variantlbl.setVisible(false);
                    resultlbl.setText(Integer.toString(statistic));
                } else {
                    sep.setVisible(false);
                    pbar.setProgress(pbar.getProgress() + 0.05);
                    rand3();
                    lblShow.setVisible(true);
                    lblQ.setText(questions[n].getQuestion());
                    lblA.setVisible(false);
                    lblA.setText(questions[n].getAnswer());
                    variantlbl.setVisible(true);
                }
            });

            lblN.setOnMousePressed(event -> {

                if (questions[n].isChoosen()) {
                    questions[n].setChoosen(false);
                    statistic++;
                }

                if (num == 0) {
                    hideVB.setVisible(false);
                    hideTop.setVisible(false);
                    hideBottom.setVisible(false);
                    results.setVisible(true);
                    variantlbl.setVisible(false);
                    resultlbl.setText(Integer.toString(statistic));
                } else {
                    rand3();
                    sep.setVisible(false);
                    lblShow.setVisible(true);
                    lblA.setVisible(false);
                    variantlbl.setVisible(true);
                }

            });
        }

        variantlbl.setOnMousePressed(mouseEvent -> {
            System.out.println("Нажал выбор варианта");
            if (radiovertical.isVisible()) {
                System.out.println("Видимо, стало невидимым");
                radiovertical.setVisible(false);
                lblShow2.setVisible(false);
                lblShow.setVisible(true);

                lblA.setVisible(false);
                sep.setVisible(false);

                lblShow.setOnMousePressed(enent -> {
                    System.out.println("Я показал ответ");
                    sep.setVisible(true);
                    lblShow.setVisible(false);
                    lblA.setVisible(true);
                    variantlbl.setVisible(false);
                });


                lblY.setOnMousePressed(event -> {
                    System.out.println("Я охренел");

                    rand2();
                    num--;

                    if (num == 0) {
                        hideVB.setVisible(false);
                        hideTop.setVisible(false);
                        hideBottom.setVisible(false);
                        results.setVisible(true);
                        variantlbl.setVisible(false);
                        resultlbl.setText(Integer.toString(statistic));
                    } else {
                        sep.setVisible(false);
                        pbar.setProgress(pbar.getProgress() + 0.05);
                        rand3();
                        lblShow.setVisible(true);
                        lblA.setVisible(false);
                        variantlbl.setVisible(true);
                    }
                });

                lblN.setOnMousePressed(event -> {

                    if (questions[n].isChoosen()) {
                        questions[n].setChoosen(false);
                        statistic++;
                    }

                    if (num == 0) {
                        hideVB.setVisible(false);
                        hideTop.setVisible(false);
                        hideBottom.setVisible(false);
                        results.setVisible(true);
                        variantlbl.setVisible(false);
                        resultlbl.setText(Integer.toString(statistic));
                    } else {
                        rand3();
                        sep.setVisible(false);
                        lblShow.setVisible(true);
                        lblA.setVisible(false);
                        variantlbl.setVisible(true);
                    }

                });
            }
            else{
                System.out.println("Невидимо, стало видимым");
                sep.setVisible(true);
                radiovertical.setVisible(true);
                lblShow2.setVisible(true);
                lblShow.setVisible(false);



                lblY.setOnMousePressed(event1 -> {
                    System.out.println("При вариантах да!");
                    rand2();
                    num--;

                        if (num == 0) {
                            hideVB.setVisible(false);
                            hideTop.setVisible(false);
                            hideBottom.setVisible(false);
                            results.setVisible(true);
                            variantlbl.setVisible(false);
                            resultlbl.setText(Integer.toString(statistic));
                        } else {
                            sep.setVisible(false);
                            pbar.setProgress(pbar.getProgress() + 0.05);
                            lblShow.setVisible(true);
                            rand3();
                            lblA.setVisible(false);
                            variantlbl.setVisible(true);
                            radiovertical.setVisible(false);
                            lblShow2.setVisible(false);
                        }
                    });
                    lblN.setOnMousePressed(event3 -> {
                        System.out.println("При вариантах нет!");
                        if (questions[n].isChoosen()) {
                            questions[n].setChoosen(false);
                            statistic++;
                        }

                        if (num == 0) {
                            hideVB.setVisible(false);
                            hideTop.setVisible(false);
                            hideBottom.setVisible(false);
                            results.setVisible(true);
                            variantlbl.setVisible(false);
                            resultlbl.setText(Integer.toString(statistic));
                        } else {
                            rand3();
                            sep.setVisible(false);
                            lblShow.setVisible(true);
                            lblA.setVisible(false);
                            variantlbl.setVisible(true);
                            radiovertical.setVisible(false);
                            lblShow2.setVisible(false);
                        }
                    });

                lblShow2.setOnMousePressed(event -> {
                    System.out.println("Нажал на показать ответ при варантах");
                    RadioButton selectedRadio = (RadioButton) radioGroup.getSelectedToggle();
                    if (selectedRadio != null) {
                        String toggleGroupValue = selectedRadio.getText();
                        if (!Objects.equals(toggleGroupValue, lblA.getText())) {statistic++;}
                        sep.setVisible(true);
                        lblA.setVisible(true);
                        radiovertical.setVisible(false);
                        lblShow2.setVisible(false);
                        variantlbl.setVisible(false);
                        lblY.setVisible(true);
                        lblN.setVisible(true);
                    }
                });
            }

        });

    }
}
































/*import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Controller {

    @FXML
    private Button clickThat;

    @FXML
    private AnchorPane anchor1;

    @FXML
    private AnchorPane anchor2;

    @FXML
    private Button button;

    @FXML
    private ToggleGroup radioGroup;

    @FXML
    private RadioButton radio1;

    @FXML
    private RadioButton radio2;

    @FXML
    Questions[] questions = new Questions[] {
            new Questions("Логика - наука?", new String[] {"Да", "Нет"}),
            new Questions("Политология наука?", new String[] {"Да", "Нет"})
    };

    private int nowQuestion = 0;
    private int correctAnswer;

    public int getNowQuestion() {
        return nowQuestion;
    }

    @FXML
    void initialize() {

        anchor2.setVisible(false);
        radio1.setText(questions[0].getAnswers()[1]);
        radio2.setText(questions[0].getAnswers()[0]);
        button.setText(questions[0].getQuestion());

        button.setOnAction(event -> {
            //нажали на кнопку

            RadioButton selectedRadio = (RadioButton) radioGroup.getSelectedToggle();
            if (selectedRadio != null) {
                String toggleGroupValue = selectedRadio.getText();

                if (toggleGroupValue.equals(questions[nowQuestion].correctAnswer())){
                    correctAnswer++;
                }

                if(nowQuestion +1 != questions.length){
                    nowQuestion++;

                    button.setText(questions[nowQuestion].getQuestion());
                    String[] answers = questions[nowQuestion].getAnswers();

                    List<String> stringList = Arrays.asList(answers);
                    Collections.shuffle(stringList);

                    radio1.setText(stringList.get(0));
                    radio2.setText(stringList.get(1));

                    selectedRadio.setSelected(false);
                } else{
                    anchor1.setVisible(false);
                    anchor2.setVisible(true);

                }
            }

        });


    }
}*/

/* @FXML
    protected void onClick1(ActionEvent event) {
        n++;
        System.out.println("Вы нажали на кнопку "+n+" раз");

    }*/


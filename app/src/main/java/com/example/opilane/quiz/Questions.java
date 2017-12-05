package com.example.opilane.quiz;



public class Questions {


    public String MyQuestions[] = {
            "Is Iphone bang for the buck?",
            "Java is used for how many devices?",
            "Is this application cool?",
            "is coca-cola healthy?",
    };
    public String MyChoices [] [] = {
            {"Yes","No","Maybe","joking right?"},
            {"1","6000","1M","18B"},
            {"Pffff","Yeaah","Get outta here","NO"},
            {"Yes","No","Someways","Def not"},
    };
    private String MyCorrectAnswers [] = {
            "No", "18B", "Get outta here", "Someways"
    };
    public int getlenght () {
        return MyQuestions.length;
    }
    public String getQuestion(int a) {
        String question = MyQuestions[a];
        return question;
    }
    public String getChoice(int index, int num) {
        String choice0=MyChoices[index] [num -1];
        return choice0;
    }
    public String getCorrectAnswer(int a) {
        String answer=MyCorrectAnswers[a];
        return  answer;
    }

}

package Resources;

import pojo.CreateActivity;

public class TestBuild {

    public CreateActivity createActivity(){
        CreateActivity createActivity = new CreateActivity();

        createActivity().setId("31");
        createActivity.setTitle("running");
        createActivity.setDueDate("2024-04-06T13:35:47.835Z");
        createActivity.setCompeleted(true);


 return createActivity;
    }
}

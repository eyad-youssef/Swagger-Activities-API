package Resources;

public enum ApiResources {
    getActivityByID("https://fakerestapi.azurewebsites.net/api/v1/Activities/1"),
    getAllActivities("https://fakerestapi.azurewebsites.net/api/v1/Activities"),
    putActivity("https://fakerestapi.azurewebsites.net/api/v1/Activities/1"),
    deleteActivity("https://fakerestapi.azurewebsites.net/api/v1/Activities/1"),
    addActivity("https://fakerestapi.azurewebsites.net/api/v1/Activities");


    private String resource;

    ApiResources(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}


package mjksabit.github.coronaupdate;

public class CountryData{
    private String name = "";
    private String totalCases = "";
    private String activeCases = "";
    private String totalRecovered = "";
    private String totalDeath = "";

    public CountryData(String name, String totalCases, String activeCases, String totalRecovered, String totalDeath) {
        this.name = name;
        this.totalCases = totalCases;
        this.activeCases = activeCases;
        this.totalRecovered = totalRecovered;
        this.totalDeath = totalDeath;
    }

    public String getName() {
        return name;
    }

    public String getLowercaseName() {
        return name.toLowerCase();
    }

    public String getTotalCases() {
        return totalCases;
    }

    public String getActiveCases() {
        return activeCases;
    }

    public String getTotalRecovered() {
        return totalRecovered;
    }

    public String getTotalDeath() {
        return totalDeath;
    }
}

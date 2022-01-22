package pages.controller.info;

public class Searchuserlist {

    private String searchQuery;

    public String getSearchQuery() {
        return this.searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery.trim();
    }
}

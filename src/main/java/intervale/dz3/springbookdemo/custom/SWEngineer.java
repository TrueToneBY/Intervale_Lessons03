package intervale.dz3.springbookdemo.custom;

public class SWEngineer {
    private long id;
    private String name;
    private String[] languages;

    public SWEngineer(long id, String name, String[] languages) {
        this.id = id;
        this.name = name;
        this.languages = languages;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getLanguages() {
        return this.languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ID: ").append(this.id).append("\nName: ")
                .append(this.name).append("\nLanguages:");

        for (String s: this.languages) {
            sb.append(" ").append(s);
        }
        return sb.toString();
    }
}

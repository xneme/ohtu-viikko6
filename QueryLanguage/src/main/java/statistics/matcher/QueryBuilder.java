package statistics.matcher;

public class QueryBuilder {

    private Matcher matcher;

    public QueryBuilder() {
        this.matcher = new All();
    }

    public Matcher build() {
        return matcher;
    }
    
    public QueryBuilder playsIn(String team) {
        matcher = new And(matcher, new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        matcher = new And(matcher, new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        matcher = new And(matcher, new HasFewerThan(value, category));
        return this;
    }
    
    public QueryBuilder not() {
        matcher = new Not(matcher);
        return this;
    }
}

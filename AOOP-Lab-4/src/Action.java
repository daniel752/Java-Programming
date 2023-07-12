public class Action
{
    private String name;
    public Action(String n)
    {
        this.name = n;
    }
    public String getName()
    {
        return this.name;
    }
    public boolean equals(Object other)
    {
        return (other instanceof Action)&&(((Action) other).getName() == this.name);
    }
}

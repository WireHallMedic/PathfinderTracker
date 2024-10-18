package PFTracker;

public class Actor
{
   public static final int NULL_INIT = -100;
	private String name;
	private String notes;
	private int actionsSpent;
	private int initiative;
	private boolean reactionSpent;


	public String getName(){return name;}
	public String getNotes(){return notes;}
	public int getActionsSpent(){return actionsSpent;}
	public int getInitiative(){return initiative;}
	public boolean isReactionSpent(){return reactionSpent;}


	public void setName(String n){name = n;}
	public void setNotes(String n){notes = n;}
	public void setActionsSpent(int a){actionsSpent = a;}
	public void setInitiative(int i){initiative = i;}
	public void setReactionSpent(boolean r){reactionSpent = r;}

   
   public Actor()
   {
      clear();
   }
   
   public void clear()
   {
      name = "";
      notes = "";
      actionsSpent = 0;
      initiative = NULL_INIT;
      reactionSpent = false;
   }
   
   public String serialize()
   {
      String nameVal = name.length() == 0 ? " " : name;
      String notesVal = notes.length() == 0 ? " " : notes;
      return nameVal.replace("$", "%dollar") + "$" +
         actionsSpent + "$" +
         reactionSpent + "$" +
         initiative + "$" +
         notesVal.replace("$", "%dollar");
   }
   
   public void deserialize(String str)
   {
      if(str.charAt(0) == '$')
         str = " " + str;
      String[] values = str.split("[$]");
      name = values[0].strip();
      actionsSpent = Integer.parseInt(values[1]);
      reactionSpent = Boolean.parseBoolean(values[2]);
      initiative = Integer.parseInt(values[3]);
      notes = values[4].strip();
   }
}
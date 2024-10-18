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
}
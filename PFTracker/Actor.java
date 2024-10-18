package PFTracker;

public class Actor
{
	private String name;
	private String notes;
	private int actionsLeft;
	private int initiative;
   public static final int NULL_INIT = 100;


	public String getName(){return name;}
	public String getNotes(){return notes;}
	public int getActionsLeft(){return actionsLeft;}
	public int getInitiative(){return initiative;}


	public void setName(String n){name = n;}
	public void setNotes(String n){notes = n;}
	public void setActionsLeft(int a){actionsLeft = a;}
	public void setInitiative(int i){initiative = i;}
   
   public Actor()
   {
      clear();
   }
   
   public void clear()
   {
      name = "";
      notes = "";
      actionsLeft = 3;
      initiative = NULL_INIT;
   }
}
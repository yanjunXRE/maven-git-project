package devopsproject;
import java.util.*;
public class forumUnitTesting {
	  private ArrayList<forum> forums = new ArrayList<>();
	    private int capacity;
	  public forumUnitTesting() {
	    	forums.add(new forum("test1","good 4 u","text"));
	    	forums.add(new forum("test2","Peaches","question"));
	    	forums.add(new forum("test3","MONTERO","text"));
	    	forums.add(new forum("test4","bad guy","guide"));

	        this.capacity = 20;
	    }
	  public forumUnitTesting(int capacity) {
	        this.capacity = capacity;
	    }

	    public List<forum> getForum() {
	        return forums;
	    }

	    public void addForum(forum forum) {
	    	if(forums.size() != capacity) {
	    		forums.add(forum);
	    	}
	    	
	    }
	    public forum findForumByTitle(String title) {
	    	for (forum s : forums) { 		      
	            if(s.getTitle().equals(title)) return s;
	       }
	    	return null;
	    }
	  
}


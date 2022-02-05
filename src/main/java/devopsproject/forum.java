package devopsproject;

public class forum {
protected String title;
protected String type;
protected String text;

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getText() {
	return text;
}

public void setText(String text) {
	this.text = text;
}
public forum(String title, String type, String text) {
	super();
	this.title = title;
	this.type = type;
	this.text = text;
}

}
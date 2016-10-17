package beans;

public class Post {
	private int postId;
	private String postTitle;
	private String postContent;
	public int getPostId() {
		return postId;
	}
	
	public Post(int postId, String postTitle, String postContent) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
		this.postContent = postContent;
	}



	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postTitle=" + postTitle + ", postContent=" + postContent + "]";
	}
	
	
}

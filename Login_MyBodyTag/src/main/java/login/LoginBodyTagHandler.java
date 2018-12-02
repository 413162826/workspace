package login;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class LoginBodyTagHandler extends BodyTagSupport {
	private String username;
	private String password;

	/** Creates new instance of tag handler */
	public LoginBodyTagHandler() {
		super();
	}

	/**
	 * Method called from doStartTag(). Fill in this method to perform other
	 * operations from doStartTag().
	 */
	private void otherDoStartTagOperations() {
		// TODO: code that performs other operations in
		// doStartTag should be placed here. It will be
		// called after initializing variables, finding the
		// parent, setting IDREFs, etc, and before calling
		// theBodyShouldBeEvaluated().

		// For example, to print something out to the JSP,
		// use the following:
		// try {
		// JspWriter out = pageContext.getOut();
		// out.println("something");
		// } catch (IOException ex) {
		// // do something
		// }
	}

	/*
	 * Method called from doEndTag(). Fill in this method to perform other
	 * operations from doEndTag().
	 */
	private void otherDoEndTagOperations() {
		// TODO: code that performs other operations in
		// doEndTag should be placed here. It will be called
		// after initializing variables, finding the parent,
		// setting IDREFs, etc, and before calling
		// shouldEvaluateRestOfPageAfterEndTag().
	}

	private void writeTagBodyContent(JspWriter out, BodyContent bodyContent) throws JspException {
		try {
			out.println("<head><title>Welcome</title></head>");
			login.LoginBean login = new login.LoginBean();
			login.setUsername(this.username);
			login.setPassword(this.password);
			boolean success = login.checklogin();
			if (success) {
				bodyContent.append("<p/>" + username + " successes**");
				pageContext.setAttribute("success", true);
			} else {
				bodyContent.append("<p/>" + username + " fails**");
				pageContext.setAttribute("success", false);
			}
			bodyContent.writeOut(out);
			out.println("<strong>" + this.username + " has learned tag body。**" + "</strong>");

			bodyContent.writeOut(out);
		} catch (java.io.IOException ex) {
			throw new JspException("Error in writeTagBodyContent() in LoginBodyTagHandler tag", ex);
		}
		bodyContent.clearBody();
	}

	/*
	 * This method is called when the JSP engine encounters the start tag, after the
	 * attributes are processed. Scripting variables (if any) have their values set
	 * here.
	 * 
	 * @return EVAL_BODY_BUFFERED if the JSP engine should evaluate the tag body,
	 * otherwise return SKIP_BODY. This method is automatically generated. Do not
	 * modify this method. Instead, modify the methods that this method calls.
	 */
	@Override
	public int doStartTag() throws JspException {
		otherDoStartTagOperations();

		if (theBodyShouldBeEvaluated()) {
			return EVAL_BODY_BUFFERED;
		} else {
			return SKIP_BODY;
		}
	}

	/**
	 * This method is called after the JSP engine finished processing the tag.
	 * 
	 * @return EVAL_PAGE if the JSP engine should continue evaluating the JSP page,
	 *         otherwise return SKIP_PAGE. This method is automatically generated.
	 *         Do not modify this method. Instead, modify the methods that this
	 *         method calls.
	 */
	@Override

	public int doEndTag() throws JspException {
		otherDoEndTagOperations();

		if (shouldEvaluateRestOfPageAfterEndTag()) {
			return EVAL_PAGE;
		} else {
			return SKIP_PAGE;
		}
	}

	/**
	 * This method is called after the JSP engine processes the body content of the
	 * tag.
	 * 
	 * @return EVAL_BODY_AGAIN if the JSP engine should evaluate the tag body again,
	 *         otherwise return SKIP_BODY. This method is automatically generated.
	 *         Do not modify this method. Instead, modify the methods that this
	 *         method calls.
	 */

	@Override
	public int doAfterBody() throws JspException {
		try {
			// This code is generated for tags whose
			// bodyContent is "JSP"
			BodyContent bodyCont = getBodyContent();
			JspWriter out = bodyCont.getEnclosingWriter();

			writeTagBodyContent(out, bodyCont);
		} catch (Exception ex) {
			handleBodyContentException(ex);
		}

		if (theBodyShouldBeEvaluatedAgain()) {
			return EVAL_BODY_AGAIN;
		} else {
			return SKIP_BODY;
		}
	}

	/**
	 * Handles exception from processing the body content.
	 */
	private void handleBodyContentException(Exception ex) throws JspException {
		// Since the doAfterBody method is guarded, place exception handing code here.
		throw new JspException("Error in LoginBodyTagHandler tag", ex);
	}

	/*
	 * Fill in this method to determine if the rest of the JSP page should be
	 * generated after this tag is finished. Called from doEndTag().
	 */
	private boolean shouldEvaluateRestOfPageAfterEndTag() {
		// TODO: code that determines whether the rest
		// of the page should be evaluated after the
		// tag is processed should be placed here.
		// Called from the doEndTag() method.
		return true;
	}

	/**
	 * Fill in this method to determine if the tag body should be evaluated again
	 * after evaluating the body. Use this method to create an iterating tag. Called
	 * from doAfterBody().
	 */
	private boolean theBodyShouldBeEvaluatedAgain() {
		// TODO: code that determines whether the tag
		// body should be evaluated again after
		// processing the tag should be placed here.
		// You can use this method to create iterating
		// tags. Called from the doAfterBody() method.
		return false;
	}

	private boolean theBodyShouldBeEvaluated() {
		// TODO: code that determines whether the body
		// should be evaluated should be placed here.
		// Called from the doStartTag() method.
		return true;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

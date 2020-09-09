package com.member;

	public class MemberVO implements java.io.Serializable {
	    private String password;
	    private String mname;
	    private int memberId;
	 
	    public int getMemberId() {
	        return memberId;
	    }
	    public void setMemberId(int id) {
	        this.memberId = id;
	    }
	    public String getPassword() {
	        return password;
	    }
	    public void setPassword(String password) {
	        this.password = password;
	    }
	    public String getMname() {
	        return mname;
	    }
	    public void setMname(String mname) {
	        this.mname = mname;
	    }
	    public String getAnonymousName(){
	        if(null==mname)
	            return null;
	         
	        if(mname.length()<=1)
	            return "*";
	         
	        if(mname.length()==2)
	            return mname.substring(0,1) +"*";
	         
	        char[] cs =mname.toCharArray();
	        for (int i = 1; i < cs.length-1; i++) {
	            cs[i]='*';
	        }
	        return new String(cs);
	         
	    }
		@Override
		public String toString() {
			return "MemberVO [password=" + password + ", mname=" + mname + ", memberId=" + memberId + "]";
		}
	     
	    
	    
	}


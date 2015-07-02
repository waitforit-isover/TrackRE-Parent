package com.sevenre.trackre.parent.datatypes;

public class ServerResult {

    Exception exception;
    boolean isAuthentic;
    String schoolId;

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public boolean isAuthentic() {
        return isAuthentic;
    }

    public void setIsAuthentic(boolean isAuthentic) {
        this.isAuthentic = isAuthentic;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }
}

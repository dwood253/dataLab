package dwood253.uw.tacoma.edu.webserviceslab.course;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Daniel on 1/31/17.
 */

public class Course implements Serializable{

    String mCourseId;
    String mShortDescription;
    String mLongDescription;
    String mPrereqs;

    public static final String ID = "id", SHORT_DESC = "shortDesc"
            , LONG_DESC = "longDesc", PRE_REQS = "prereqs";


    public Course(String mCourseID, String mShortDescription, String mLongDescription, String mPrereqs) {
        this.mCourseId = mCourseID;
        this.mShortDescription = mShortDescription;
        this.mLongDescription = mLongDescription;
        this.mPrereqs = mPrereqs;
    }

    /**
     * Parses the json string, returns an error message if unsuccessful.
     * Returns course list if success.
     * @param courseJSON
     * @return reason or null if successful.
     */
    public static String parseCourseJSON(String courseJSON, List<Course> courseList) {
        String reason = null;
        if (courseJSON != null) {
            try {
                JSONArray arr = new JSONArray(courseJSON);

                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    Course course = new Course(obj.getString(Course.ID), obj.getString(Course.SHORT_DESC)
                            , obj.getString(Course.LONG_DESC), obj.getString(Course.PRE_REQS));
                    courseList.add(course);
                }
            } catch (JSONException e) {
                reason =  "Unable to parse data, Reason: " + e.getMessage();
            }

        }
        return reason;
    }


    public String getPrereqs() {
        return mPrereqs;
    }

    public String getCourseId() {
        return mCourseId;
    }

    public String getShortDescription() {
        return mShortDescription;
    }

    public String getLongDescription() {
        return mLongDescription;
    }

    public void setPrereqs(String mPrereqs) {

        this.mPrereqs = mPrereqs;
    }

    public void setCourseID(String mCourseID) {
        this.mCourseId = mCourseID;
    }

    public void setShortDescription(String mShortDescription) {
        this.mShortDescription = mShortDescription;
    }

    public void setLongDescription(String mLongDescription) {
        this.mLongDescription = mLongDescription;
    }

}

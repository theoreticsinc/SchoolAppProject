package models;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import models.Newsletter;
/**
 * Created by Angelo on 9/30/2015.
 */
public class PageModel {

    @SerializedName("newsletters")
    public Newsletter newsletters;
}

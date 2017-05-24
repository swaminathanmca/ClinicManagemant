package com.lissomsoft.clinic.domain;

/**
 * Created by Lissomsoft on 05/24/17.
 */
public class Laboratory {

    private Integer test_id;
    private String test_type;
    private String test_name;
    private String description;

    public Integer getTest_id() {
        return test_id;
    }

    public void setTest_id(Integer test_id) {
        this.test_id = test_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTest_type() {
        return test_type;
    }

    public void setTest_type(String test_type) {
        this.test_type = test_type;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }



    public String toString(){
        return "Laboratory{"+
                "test_id="+test_id+
                "test_type="+test_type+
                "test_name="+test_name+
                "description="+description+

                '}';
    }
}

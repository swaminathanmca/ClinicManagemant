package com.lissomsoft.clinic.controller;

import com.lissomsoft.clinic.service.UserServiceImpl;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.lissomsoft.clinic.domain.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import com.lissomsoft.clinic.service.UserService;
import com.lissomsoft.clinic.service.ClinicService;


@Controller
@Component

public class HelloController {
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired(required = false)
    private UserService userService;
    @Autowired(required = false)
    private ClinicService clinicService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/")
    public String homePage(HttpServletRequest request) throws Exception {
        return "login";
    }


    @RequestMapping(value = "/GetPatient", method = RequestMethod.GET)
    public
    @ResponseBody
    String getPatient() throws JSONException {
    /*	model.addAttribute("message", "Hello world!");*/
        JSONArray jsonArray = new JSONArray();
        JSONObject mainObj = new JSONObject();
        JSONObject jsonObject = new JSONObject();
        Patient patient = new Patient();
        patient.setFullName("Jayaswaminathan");
        patient.setBloodGroup("AB");
        patient.setDob("24/07/1992");
        patient.setFactor("Positive");
        patient.setGender("Male");
        patient.setmStatus("Single");
        patient.setStatus("active");
        jsonObject.put("FullName", patient.getFullName());
        jsonObject.put("BloodGroup", patient.getBloodGroup());
        jsonObject.put("Dob", patient.getDob());
        jsonObject.put("Factor", patient.getFactor());
        jsonObject.put("Gender", patient.getGender());
        jsonObject.put("Mstatus", patient.getmStatus());
        jsonObject.put("Status", patient.getStatus());
        jsonArray.put(jsonObject);
        mainObj.put("Patient", jsonArray);
        return mainObj.toString();
    }

    @RequestMapping(value = "/SignIn", method = RequestMethod.POST)
    public
    @ResponseBody
    String signin(@RequestBody User user, HttpServletRequest request) throws JSONException {

        HttpSession session = request.getSession();
        //System.out.println("Hello"+user.toString());

        String message="Enter Correct Username And Password";
        List<User> userList;
        JSONObject jsonObject = new JSONObject();
        JSONObject data = new JSONObject();
        JSONObject status = new JSONObject();
        userList = userService.authenticateUser(user.getUsername(), user.getPassword());

        Iterator<User> it = userList.iterator();


        if (it.hasNext()) {
            while (it.hasNext()) {

                User userdetails = it.next();

                jsonObject.put("username", userdetails.getUsername());
                jsonObject.put("email_id", userdetails.getEmail_id());
                jsonObject.put("role_name", userdetails.getRole_name());
                data.put("data", jsonObject);
                status.put("status", true);
                data.put("status", true);

            }
        } else {
            data.put("status", false);
            data.put("message",message);
        }


        return data.toString();


    }

    @RequestMapping(value = "/Dashboard")
    public String dashBoard(HttpServletRequest request) throws Exception {
        return "addClinic";
    }

    @RequestMapping(value = "/AddClinic", method = RequestMethod.POST)
    public
    @ResponseBody
    String addClinic(@RequestBody Clinic clinic, HttpServletRequest request) throws JSONException {
      JSONObject jsonObject=new JSONObject();
        boolean flag;
     //   System.out.println(branch);
        flag = clinicService.addClinic(clinic);
        jsonObject.put("status",flag);
        return jsonObject.toString();
    }


    @RequestMapping(value = "/EditClinic", method = RequestMethod.POST)
    public
    @ResponseBody
    String editClinic(@RequestBody Clinic clinic, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject=new JSONObject();
        boolean flag;
         System.out.println(clinic);
       flag = clinicService.editClinic(clinic);
        jsonObject.put("status",flag);
        return jsonObject.toString();
    }

    @RequestMapping(value = "/GetClinic")
    public String getClinic(HttpServletRequest request) throws Exception {
        return "viewClinic";
    }



    @RequestMapping(value ="/ViewClinic",method = RequestMethod.GET)
    public
    @ResponseBody
    String viewClinic()throws Exception{


        JSONArray jsonArray=new JSONArray();
        JSONObject sendResponse=new JSONObject();
        List<Clinic> clinicDetails;
        clinicDetails=clinicService.getClinic();

        Iterator<Clinic> it = clinicDetails.iterator();
        while (it.hasNext()){
            Clinic clinicdetails=it.next();

            JSONObject jsonObject =new JSONObject();
            jsonObject.put("clinicId",clinicdetails.getClinic_id());
            jsonObject.put("clinicName",clinicdetails.getClinic_name());
            jsonObject.put("phoneNo",clinicdetails.getContact_no());
            jsonObject.put("emailid",clinicdetails.getEmail_id());
            jsonObject.put("address",clinicdetails.getAddress());
            jsonObject.put("description",clinicdetails.getDescription());

            jsonArray.put(jsonObject);
            sendResponse.put("clinic",jsonArray);
            sendResponse.put("status",true);

        }


        return sendResponse.toString();
    }


    @RequestMapping(value ="/validate/{contact_no}",method = RequestMethod.GET)
    public
    @ResponseBody
    String validate(@PathVariable String contact_no) throws JSONException {

       boolean satus;
        JSONObject data = new JSONObject();
        List<Clinic> validateClinic;

        validateClinic= clinicService.validateno(contact_no);
        if(validateClinic.isEmpty()){
            data.put("status", true);
        }
        else{
            data.put("status",false);
        }

        return data.toString();
    }

    @RequestMapping(value = "/emailvalidate/{email_id:.+}",method = RequestMethod.GET)
    public
    @ResponseBody
    String emailvalidate(@PathVariable String email_id)throws JSONException{
        JSONObject datajson=new JSONObject();
        List<Clinic> emailValidate;

        emailValidate=clinicService.email(email_id);
        if(emailValidate.isEmpty()){
            datajson.put("status",true);
        }
        else
        {
            datajson.put("status",false);
        }

        return datajson.toString();
    }

    @RequestMapping(value = "/GetDetails/{id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String getDetails(@PathVariable Integer id)throws Exception{

        JSONObject jsonObject=new JSONObject();
        List<Clinic> getDetails;
        getDetails=clinicService.getClinicById(id);
        Iterator<Clinic> it = getDetails.iterator();
        while (it.hasNext()){
            Clinic clinicdetails=it.next();
            jsonObject.put("clinicId",clinicdetails.getClinic_id());
            jsonObject.put("clinicName",clinicdetails.getClinic_name());
            jsonObject.put("phone_no",clinicdetails.getContact_no());
            jsonObject.put("email_id",clinicdetails.getEmail_id());
            jsonObject.put("description",clinicdetails.getDescription());
            jsonObject.put("address",clinicdetails.getAddress());
            jsonObject.put("city",clinicdetails.getCity());
            jsonObject.put("pincode",clinicdetails.getPincode());
            jsonObject.put("state",clinicdetails.getState());
            jsonObject.put("status",true);

        }

        return jsonObject.toString();

    }

    @RequestMapping(value ="/validate/{contact_no}/{clinicID}",method = RequestMethod.GET)
    public
    @ResponseBody
    String validateId(@PathVariable String contact_no,@PathVariable Integer clinicID) throws JSONException {
        JSONObject data = new JSONObject();
        List<Clinic> validateClinic;
        validateClinic= clinicService.validateno(contact_no);

        if(validateClinic.isEmpty()){
            data.put("status", true);
        }
        else{
            Iterator<Clinic> it=validateClinic.iterator();
            while (it.hasNext()){
                Clinic validateNo=it.next();

                if(validateNo.getClinic_id()==clinicID){
                    data.put("status", true);
                }else {
                    data.put("status",false);
                }
            }
        }
        return data.toString();
    }
    @RequestMapping(value = "/emailvalidate/{email_id:.+}/{clinicID}",method = RequestMethod.GET)
    public
    @ResponseBody
    String emailvalidateId(@PathVariable String email_id,@PathVariable Integer clinicID)throws JSONException{
        JSONObject datajson=new JSONObject();
        List<Clinic> emailValidate;

        emailValidate=clinicService.email(email_id);
        if(emailValidate.isEmpty()){
            datajson.put("status",true);
        }
        else
        {
            Iterator<Clinic> it=emailValidate.iterator();
            while (it.hasNext()){
                Clinic validateEmail=it.next();
                if(validateEmail.getClinic_id()==clinicID){
                    datajson.put("status",true);
                }else {
                    datajson.put("status", false);
                }
            }

        }

        return datajson.toString();
    }
    @RequestMapping(value = "/DeleteClinic/{clinicID}",method = RequestMethod.DELETE)
    public
    @ResponseBody
    String deleteClinic(@PathVariable Integer clinicID)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        boolean deleteClinic;
        deleteClinic=clinicService.deleteclinic(clinicID);
        jsonObject.put("status",deleteClinic);
       return jsonObject.toString();
    }

}
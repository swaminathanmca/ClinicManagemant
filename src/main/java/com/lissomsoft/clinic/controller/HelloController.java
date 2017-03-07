package com.lissomsoft.clinic.controller;

import com.lissomsoft.clinic.service.ProfileService;
import com.lissomsoft.clinic.service.UserServiceImpl;
import com.sun.deploy.panel.ITreeNode;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.lissomsoft.clinic.domain.*;
import com.lissomsoft.clinic.vo.*;

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
    @Autowired(required = false)
    private ProfileService profileService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/")
    public String homePage(HttpServletRequest request) throws Exception {
        return "login";
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

        userList = userService.authenticateUser(user.getEmail_id(), user.getPassword());

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
    String addClinic(@RequestBody ClinicUser clinic ,HttpServletRequest request) throws JSONException {
      JSONObject jsonObject=new JSONObject();
        boolean flag;

        flag = clinicService.addClinic(clinic);
        jsonObject.put("status",flag);
        return jsonObject.toString();
    }


    @RequestMapping(value = "/EditClinic", method = RequestMethod.POST)
    public
    @ResponseBody
    String editClinic(@RequestBody ClinicUser clinicUser, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject=new JSONObject();
        boolean flag;
        System.out.println(clinicUser);
       flag = clinicService.editClinic(clinicUser);
        jsonObject.put("status",flag);
        return jsonObject.toString();
    }
    @RequestMapping(value = "/ViewDetails/{clinic_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String viewDetails(@PathVariable Integer clinic_id)throws JSONException{

        JSONObject data=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        List<ClinicUser> viewClinic;
        viewClinic =  clinicService.clinicDetails(clinic_id);
        Iterator<ClinicUser> it = viewClinic.iterator();
        while (it.hasNext()){

            ClinicUser clinicdetails=it.next();

            JSONObject jsonObject =new JSONObject();
            jsonObject.put("clinicId",clinicdetails.getClinic_id());
            jsonObject.put("clinicName",clinicdetails.getClinic_name());
            jsonObject.put("Chief",clinicdetails.getChief_name());
            jsonObject.put("reg_no",clinicdetails.getRegister_no());
            jsonObject.put("st",clinicdetails.getStatus());
            jsonObject.put("address1",clinicdetails.getAddress1());
            jsonObject.put("address2",clinicdetails.getAddress2());
            jsonObject.put("city",clinicdetails.getCity());
            jsonObject.put("state",clinicdetails.getState());
            jsonObject.put("country",clinicdetails.getCountry());
            jsonObject.put("pin_code",clinicdetails.getPin_code());
            jsonObject.put("contact_no",clinicdetails.getContact_no());
            jsonObject.put("email_id",clinicdetails.getEmail_id());
            jsonObject.put("description",clinicdetails.getDescription());
            jsonObject.put("Chief_address1",clinicdetails.getChief_address1());
            jsonObject.put("Chief_address2",clinicdetails.getChief_address2());
            jsonObject.put("Chief_city",clinicdetails.getChief_city());
            jsonObject.put("Chief_state",clinicdetails.getChief_state());
            jsonObject.put("chief_country",clinicdetails.getChief_country());
            jsonObject.put("Chief_conatct_no",clinicdetails.getChief_contact_no());
            jsonObject.put("Chief_email_id",clinicdetails.getChief_email_id());
            jsonObject.put("Chief_pincode",clinicdetails.getChief_pin_code());
            jsonObject.put("Chief_gender",clinicdetails.getGender());
            jsonObject.put("Chief_id",clinicdetails.getChief_id());
            data.put("success",true);
            data.put("clinic",jsonObject);

        }
        return data.toString();
    }
    @RequestMapping(value = "/GetClinic")
    public String getClinic(HttpServletRequest request) throws Exception {
        return "viewClinic";
    }

    @RequestMapping(value = "/clinicDetails")
    public String clinicDetails(HttpServletRequest request)throws Exception{
        return "clinicDetails";
    }


    @RequestMapping(value = "/AddUser")
    public String addUser(HttpServletRequest request)throws Exception{
        return "addUser";
    }

    @RequestMapping(value ="/ViewClinic",method = RequestMethod.GET)
    public
    @ResponseBody
    String viewClinic()throws Exception{


        JSONArray jsonArray=new JSONArray();
        JSONObject sendResponse=new JSONObject();
        List<ClinicUser> clinicDetails;
        clinicDetails=clinicService.getClinic();

        Iterator<ClinicUser> it = clinicDetails.iterator();
        while (it.hasNext()){

            ClinicUser clinicdetails=it.next();

            JSONObject jsonObject =new JSONObject();
            jsonObject.put("clinicId",clinicdetails.getClinic_id());
            jsonObject.put("clinicName",clinicdetails.getClinic_name());
            jsonObject.put("Chief",clinicdetails.getChief_name());
            jsonObject.put("reg_no",clinicdetails.getRegister_no());
            jsonObject.put("st",clinicdetails.getStatus());
            jsonObject.put("address1",clinicdetails.getAddress1());
            jsonObject.put("address2",clinicdetails.getAddress2());
            jsonObject.put("city",clinicdetails.getCity());
            jsonObject.put("state",clinicdetails.getState());
            jsonObject.put("country",clinicdetails.getCountry());
            jsonObject.put("pin_code",clinicdetails.getPin_code());
            jsonObject.put("contact_no",clinicdetails.getContact_no());
            jsonObject.put("email_id",clinicdetails.getEmail_id());
            jsonObject.put("description",clinicdetails.getDescription());
            jsonObject.put("Chief_id",clinicdetails.getChief_id());


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
        List<Branch> validateClinic;

        validateClinic= clinicService.validateno(contact_no);
        if(validateClinic.isEmpty()){
            data.put("status", true);
        }
        else{
            data.put("status",false);
        }

        return data.toString();
    }

    @RequestMapping(value = "/validateChief/{contact_no}",method = RequestMethod.GET)
    public
    @ResponseBody
    String validateChief(@PathVariable String contact_no)throws JSONException{


        JSONObject data=new JSONObject();
        List<Profile> validateContact;
        validateContact=profileService.validateno(contact_no);
        if(validateContact.isEmpty()){
            data.put("status",true);
        }else{
            data.put("status",false);
        }


        return data.toString();
    }

    @RequestMapping(value = "/valName/{clinic_name}",method = RequestMethod.GET)
    public
    @ResponseBody
    String valName(@PathVariable String clinic_name)throws JSONException{

        JSONObject data=new JSONObject();
        List<Clinic> validateName;
        validateName=clinicService.validateName(clinic_name);
        if(validateName.isEmpty()){
            data.put("status",true);
        }else{

            data.put("status",false);
        }

        return data.toString();

    }

    @RequestMapping(value = "/EditName/{clinic_id}/{clinic_name}",method = RequestMethod.GET)
    public
    @ResponseBody
    String EditName(@PathVariable Integer clinic_id,@PathVariable String clinic_name)throws JSONException{

        JSONObject data=new JSONObject();
        List<Clinic> validateName;
        validateName=clinicService.validateName(clinic_name);
        if(validateName.isEmpty()){
            data.put("status",true);
        }else{
            Iterator<Clinic> it=validateName.iterator();
            while (it.hasNext()){
                Clinic validatename=it.next();
                if(clinic_id==validatename.getClinic_id()){
                    data.put("status",true);
                }else {
                    data.put("status",false);
                }

                }

        }
        return data.toString();
    }

    @RequestMapping(value = "/EditEmail/{clinic_id}/{clinic_email:.+}",method = RequestMethod.GET)
    public
    @ResponseBody
    String EditEmail(@PathVariable Integer clinic_id,@PathVariable String clinic_email)throws JSONException{

        JSONObject data=new JSONObject();
        List<Branch> editEmail;

        editEmail=clinicService.email(clinic_email);
        if(editEmail.isEmpty()){
            data.put("status",true);
        }else{
            Iterator<Branch> it=editEmail.iterator();
            while (it.hasNext()){
                Branch emailValidate=it.next();

                if(clinic_id==emailValidate.getClinic_id()){
                    data.put("status",true);
                }else {
                    data.put("status",false);
                }

            }

        }
        return data.toString();
    }

    @RequestMapping(value = "/validateEmail/{email:.+}",method = RequestMethod.GET)
    public
    @ResponseBody
    String validateEmail(@PathVariable String email)throws JSONException{
        JSONObject data=new JSONObject();
        List<Profile>validateEmail;
        validateEmail=profileService.validateEmail(email);
        if(validateEmail.isEmpty()){
            data.put("status",true);
        }else{
            data.put("status",false);
        }

        return data.toString();
    }

    @RequestMapping(value = "/trackSession/{email:.+}",method = RequestMethod.GET)
    public
    @ResponseBody
    String trackSession(@PathVariable String email)throws JSONException{

        JSONObject data=new JSONObject();
        List<ClinicUser> emailValidate;
        emailValidate=clinicService.track_id(email);
        Iterator<ClinicUser> itr=emailValidate.iterator();
        while (itr.hasNext()){
            ClinicUser cuser=itr.next();
            data.put("clinic_id",cuser.getClinic_id());
            data.put("branch_id",cuser.getBranch_id());
            data.put("clinic_name",cuser.getClinic_name());
            data.put("ho",cuser.getHo());
            data.put("branch_name",cuser.getBranch_name());
            data.put("status",true);
        }


        return data.toString();
    }

    @RequestMapping(value = "/EditChiefEmail/{chief_id}/{email_id:.+}",method = RequestMethod.GET)
    public
    @ResponseBody
    String EditChiefEmail(@PathVariable Integer chief_id,@PathVariable String email_id)throws JSONException{
        JSONObject data=new JSONObject();
        List<Profile>validateEmail;
        validateEmail=profileService.validateEmail(email_id);
        if(validateEmail.isEmpty()){
            data.put("status",true);
        }else{
            Iterator<Profile> it=validateEmail.iterator();
            while (it.hasNext()){
                Profile emailChief=it.next();
                if(chief_id==emailChief.getProfile_id()){
                    data.put("status",true);
                }else{
                    data.put("status",false);
                }
            }

        }

        return data.toString();
    }

    @RequestMapping(value = "/emailvalidate/{email_id:.+}",method = RequestMethod.GET)
    public
    @ResponseBody
    String emailvalidate(@PathVariable String email_id)throws JSONException{
        JSONObject datajson=new JSONObject();
        List<Branch> emailValidate;

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



    @RequestMapping(value ="/EditChiefContact/{chief_id}/{cihef_contactno}",method = RequestMethod.GET)
    public
    @ResponseBody
    String validateId(@PathVariable Integer chief_id,@PathVariable String cihef_contactno) throws JSONException {
        JSONObject data = new JSONObject();
        List<Profile> validateContact;
        validateContact= profileService.validateno(cihef_contactno);

        if(validateContact.isEmpty()){
            data.put("status", true);
        }
        else{
            Iterator<Profile> it=validateContact.iterator();
            while (it.hasNext()){
                Profile validateNo=it.next();

                if(validateNo.getProfile_id()==chief_id){
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
        List<Branch> emailValidate;

        emailValidate=clinicService.email(email_id);
        if(emailValidate.isEmpty()){
            datajson.put("status",true);
        }
        else
        {
            Iterator<Branch> it=emailValidate.iterator();
            while (it.hasNext()){
                Branch validateEmail=it.next();
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
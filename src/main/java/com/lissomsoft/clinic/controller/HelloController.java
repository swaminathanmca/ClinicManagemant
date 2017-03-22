package com.lissomsoft.clinic.controller;

import com.lissomsoft.clinic.service.*;
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
    @Autowired(required = false)
    private BranchService branchService;
    @Autowired(required = false)
    private DoctorService doctorService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/")
    public String homePage(HttpServletRequest request) throws Exception {
        return "login";
    }

    @RequestMapping(value = "/Login")
    public String login(HttpServletRequest request) throws Exception {
        return "login";
    }

    @RequestMapping(value = "/Dashboard")
    public String dashBoard(HttpServletRequest request) throws Exception {
        return "addClinic";
    }

    @RequestMapping(value = "/AddBranch")
    public String addBranch(HttpServletRequest request) throws Exception {
        return "addBranch";
    }

    @RequestMapping(value = "/GetBranch")
    public String getBranch(HttpServletRequest request) throws Exception {
        return "viewBranch";
    }

    @RequestMapping(value = "/GetClinic")
    public String getClinic(HttpServletRequest request) throws Exception {
        return "viewClinic";
    }

    @RequestMapping(value = "/clinicDetails")
    public String clinicDetails(HttpServletRequest request) throws Exception {
        return "clinicDetails";
    }

    @RequestMapping(value = "/doctorDetail")
    public String doctorDetails(HttpServletRequest request) throws Exception {
        return "doctorDetails";
    }

    @RequestMapping(value = "/EditBranch")
    public String editBranch(HttpServletRequest request) throws Exception {
        return "branchDetails";
    }

    @RequestMapping(value = "/AddDoctor")
    public String addUser(HttpServletRequest request) throws Exception {
        return "addDoctor";
    }

    @RequestMapping(value = "/AddFrontDesk")
    public  String addFrontdesk(HttpServletRequest request)throws Exception{
        return "addFrontdesk";
    }

    @RequestMapping(value = "/AddPatient")
    public String addPatient(HttpServletRequest request) throws Exception {
        return "patientReg";
    }

    @RequestMapping(value = "/ViewDoctor")
    public String addDoctor(HttpServletRequest request) throws Exception {
        return "viewDoctor";
    }

    @RequestMapping(value = "/ViewFrontDesk")
    public String viewFrontdesk(HttpServletRequest request)throws  Exception{

        return "viewFrontdesk";
    }

    @RequestMapping(value = "/PatientVisit")
    public String patientVisit(HttpServletRequest request) throws Exception {
        return "patientVisit";
    }

    @RequestMapping(value = "/AdminBranch")
    public String adminBranch(HttpServletRequest request) throws Exception {
        return "adminBranch";
    }

    @RequestMapping(value = "/SignIn", method = RequestMethod.POST)
    public
    @ResponseBody
    String signin(@RequestBody User user, HttpServletRequest request) throws JSONException {

        HttpSession session = request.getSession();
        //System.out.println("Hello"+user.toString());

        String message = "Enter Correct Username And Password";
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
            data.put("message", message);
        }


        return data.toString();


    }


    @RequestMapping(value = "/AddClinic", method = RequestMethod.POST)
    public
    @ResponseBody
    String addClinic(@RequestBody ClinicUser clinic, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        boolean flag;

        flag = clinicService.addClinic(clinic);
        jsonObject.put("status", flag);
        return jsonObject.toString();
    }

    @RequestMapping(value = "/AddBranch", method = RequestMethod.POST)
    public
    @ResponseBody
    String addBranch(@RequestBody ClinicUser branch, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        boolean flag;
        flag = branchService.addBranch(branch);

        jsonObject.put("status", flag);
        return jsonObject.toString();
    }


    @RequestMapping(value = "/AddDoctor", method = RequestMethod.POST)
    public
    @ResponseBody
    String addDoctor(@RequestBody DoctorUser doctor, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        boolean flag;

        flag = doctorService.addDoctor(doctor);

        jsonObject.put("status", flag);

        return jsonObject.toString();
    }


    @RequestMapping(value = "/AddFrontDesk",method = RequestMethod.POST)
    public
    @ResponseBody
    String addFrontDesk(@RequestBody DoctorUser frontdesk,HttpServletRequest request)throws JSONException{

        JSONObject data=new JSONObject();
        boolean flag;
        flag=doctorService.addFrontdesk(frontdesk);
        data.put("status",flag);

        return data.toString();
    }

    @RequestMapping(value = "/EditClinic", method = RequestMethod.POST)
    public
    @ResponseBody
    String editClinic(@RequestBody ClinicUser clinicUser, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        boolean flag;

        flag = clinicService.editClinic(clinicUser);
        jsonObject.put("status", flag);
        return jsonObject.toString();
    }

    @RequestMapping(value = "/EditBranch", method = RequestMethod.POST)
    public
    @ResponseBody
    String editBranch(@RequestBody ClinicUser clinicUser, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        boolean flag;
        flag = branchService.editBranch(clinicUser);
        jsonObject.put("status", flag);


        return jsonObject.toString();
    }

    @RequestMapping(value = "/ViewDetails/{clinic_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String viewDetails(@PathVariable Integer clinic_id) throws JSONException {

        JSONObject data = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<ClinicUser> viewClinic;
        viewClinic = clinicService.clinicDetails(clinic_id);
        Iterator<ClinicUser> it = viewClinic.iterator();
        while (it.hasNext()) {

            ClinicUser clinicdetails = it.next();

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("clinicId", clinicdetails.getClinic_id());
            jsonObject.put("clinicName", clinicdetails.getClinic_name());
            jsonObject.put("Chief", clinicdetails.getChief_name());
            jsonObject.put("reg_no", clinicdetails.getRegister_no());
            jsonObject.put("password", clinicdetails.getPassword());
            jsonObject.put("st", clinicdetails.getStatus());
            jsonObject.put("address1", clinicdetails.getAddress1());
            jsonObject.put("address2", clinicdetails.getAddress2());
            jsonObject.put("city", clinicdetails.getCity());
            jsonObject.put("state", clinicdetails.getState());
            jsonObject.put("country", clinicdetails.getCountry());
            jsonObject.put("pin_code", clinicdetails.getPin_code());
            jsonObject.put("contact_no", clinicdetails.getContact_no());
            jsonObject.put("email_id", clinicdetails.getEmail_id());
            jsonObject.put("description", clinicdetails.getDescription());
            jsonObject.put("Chief_address1", clinicdetails.getChief_address1());
            jsonObject.put("Chief_address2", clinicdetails.getChief_address2());
            jsonObject.put("Chief_city", clinicdetails.getChief_city());
            jsonObject.put("Chief_state", clinicdetails.getChief_state());
            jsonObject.put("chief_country", clinicdetails.getChief_country());
            jsonObject.put("Chief_conatct_no", clinicdetails.getChief_contact_no());
            jsonObject.put("Chief_email_id", clinicdetails.getChief_email_id());
            jsonObject.put("Chief_pincode", clinicdetails.getChief_pin_code());
            jsonObject.put("Chief_gender", clinicdetails.getGender());
            jsonObject.put("Chief_id", clinicdetails.getChief_id());
            data.put("success", true);
            data.put("clinic", jsonObject);

        }
        return data.toString();
    }

    @RequestMapping(value = "/ViewDoctor/{branch_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String viewDoctor(@PathVariable Integer branch_id) throws Exception {

        List<Profile> viewDoctor;
        viewDoctor = doctorService.viewDoctor(branch_id);
        JSONObject data = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        Iterator<Profile> it = viewDoctor.iterator();

        while (it.hasNext()) {
            JSONObject jsonObject = new JSONObject();

            Profile profile = it.next();
            jsonObject.put("profile_id", profile.getProfile_id());
            jsonObject.put("name", profile.getName());
            jsonObject.put("address1", profile.getAddress1());
            jsonObject.put("address2", profile.getAddress2());
            jsonObject.put("contact_no", profile.getContact_no());
            jsonObject.put("email_id", profile.getEmail());
            jsonArray.put(jsonObject);
            data.put("user", jsonArray);
        }

        return data.toString();
    }


    @RequestMapping(value = "/ViewClinic", method = RequestMethod.GET)
    public
    @ResponseBody
    String viewClinic() throws Exception {
        JSONArray jsonArray = new JSONArray();
        JSONObject sendResponse = new JSONObject();
        List<ClinicUser> clinicDetails;
        clinicDetails = clinicService.getClinic();

        Iterator<ClinicUser> it = clinicDetails.iterator();
        while (it.hasNext()) {
            ClinicUser clinicdetails = it.next();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("clinicId", clinicdetails.getClinic_id());
            jsonObject.put("clinicName", clinicdetails.getClinic_name());
            jsonObject.put("Chief", clinicdetails.getChief_name());
            jsonObject.put("reg_no", clinicdetails.getRegister_no());
            jsonObject.put("st", clinicdetails.getStatus());
            jsonObject.put("address1", clinicdetails.getAddress1());
            jsonObject.put("address2", clinicdetails.getAddress2());
            jsonObject.put("city", clinicdetails.getCity());
            jsonObject.put("state", clinicdetails.getState());
            jsonObject.put("country", clinicdetails.getCountry());
            jsonObject.put("pin_code", clinicdetails.getPin_code());
            jsonObject.put("contact_no", clinicdetails.getContact_no());
            jsonObject.put("email_id", clinicdetails.getEmail_id());
            jsonObject.put("description", clinicdetails.getDescription());
            jsonObject.put("Chief_id", clinicdetails.getChief_id());
            jsonArray.put(jsonObject);
            sendResponse.put("clinic", jsonArray);
            sendResponse.put("status", true);
        }
        return sendResponse.toString();
    }

    @RequestMapping(value = "/ViewBranch/{clinic_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String viewBranch(@PathVariable Integer clinic_id) throws Exception {
        JSONArray jsonArray = new JSONArray();
        JSONObject sendResponse = new JSONObject();
        List<Branch> branchDetails;
        branchDetails = branchService.getBranch(clinic_id);
        Iterator<Branch> it = branchDetails.iterator();
        while (it.hasNext()) {
            Branch branch = it.next();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("branch_name", branch.getBranch_name());
            jsonObject.put("clinic_id", branch.getChief_id());
            jsonObject.put("branch_id", branch.getBranch_id());
            jsonObject.put("description", branch.getDescripton());
            jsonObject.put("address1", branch.getAddress1());
            jsonObject.put("address2", branch.getAddress2());
            jsonObject.put("contact_no", branch.getContact_no());
            jsonArray.put(jsonObject);
            sendResponse.put("branch", jsonArray);
            sendResponse.put("status", true);
        }
        return sendResponse.toString();
    }

    @RequestMapping(value = "/ViewFrontdesk/{branch_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String viewFrontDesk(@PathVariable Integer branch_id)throws Exception{
        JSONArray jsonArray=new JSONArray();
        JSONObject data=new JSONObject();
        List<Profile> frontDesk;
        frontDesk=doctorService.viewFrontDesk(branch_id);
        Iterator<Profile> it = frontDesk.iterator();

        while (it.hasNext()) {
            JSONObject jsonObject = new JSONObject();

            Profile profile = it.next();
            jsonObject.put("profile_id", profile.getProfile_id());
            jsonObject.put("name", profile.getName());
            jsonObject.put("address1", profile.getAddress1());
            jsonObject.put("address2", profile.getAddress2());
            jsonObject.put("contact_no", profile.getContact_no());
            jsonObject.put("email_id", profile.getEmail());
            jsonArray.put(jsonObject);
            data.put("user", jsonArray);
        }

        return data.toString();
    }

    @RequestMapping(value = "/BranchDetails/{branch_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String branchDetails(@PathVariable Integer branch_id) throws Exception {

        JSONObject data = new JSONObject();
        List<ClinicUser> branchInfo;
        branchInfo = branchService.getDetails(branch_id);


        Iterator<ClinicUser> it = branchInfo.iterator();
        while (it.hasNext()) {
            ClinicUser branch = it.next();
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("clinicId", branch.getClinic_id());
            jsonObject.put("branch_name", branch.getBranch_name());
            jsonObject.put("branch_id", branch.getBranch_id());
            jsonObject.put("Chief", branch.getChief_name());
            jsonObject.put("reg_no", branch.getRegister_no());
            jsonObject.put("password", branch.getPassword());
            jsonObject.put("st", branch.getStatus());
            jsonObject.put("address1", branch.getAddress1());
            jsonObject.put("address2", branch.getAddress2());
            jsonObject.put("city", branch.getCity());
            jsonObject.put("state", branch.getState());
            jsonObject.put("country", branch.getCountry());
            jsonObject.put("pin_code", branch.getPin_code());
            jsonObject.put("contact_no", branch.getContact_no());
            jsonObject.put("email_id", branch.getEmail_id());
            jsonObject.put("description", branch.getDescription());
            jsonObject.put("Chief_address1", branch.getChief_address1());
            jsonObject.put("Chief_address2", branch.getChief_address2());
            jsonObject.put("Chief_city", branch.getChief_city());
            jsonObject.put("Chief_state", branch.getChief_state());
            jsonObject.put("chief_country", branch.getChief_country());
            jsonObject.put("Chief_conatct_no", branch.getChief_contact_no());
            jsonObject.put("Chief_email_id", branch.getChief_email_id());
            jsonObject.put("Chief_pincode", branch.getChief_pin_code());
            jsonObject.put("Chief_gender", branch.getGender());
            jsonObject.put("Chief_id", branch.getChief_id());
            data.put("success", true);
            data.put("branch", jsonObject);


        }


        return data.toString();
    }


    @RequestMapping(value = "/doctorDetails/{profile_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String doctorDetails(@PathVariable Integer profile_id) throws Exception {

        JSONObject data = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<DoctorUser> doctorDetails;
        doctorDetails = doctorService.doctorDetails(profile_id);
        Iterator<DoctorUser> it = doctorDetails.iterator();
        while (it.hasNext()) {

            DoctorUser user = it.next();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", user.getFirstname());
            jsonObject.put("address1", user.getAddress1());
            jsonObject.put("address2", user.getAddress2());
            jsonObject.put("city", user.getCity());
            jsonObject.put("state", user.getState());
            jsonObject.put("country", user.getCountry());
            jsonObject.put("pincode", user.getPincode());
            jsonObject.put("gender", user.getGender());
            jsonObject.put("email", user.getEmail_id());
            jsonObject.put("phone", user.getContact_no());
            jsonObject.put("clinic_name", user.getClinic_name());
            jsonObject.put("branch_name", user.getBranch_name());
            jsonObject.put("qualification", user.getQualification());
            jsonObject.put("specialization", user.getSpecialization());
            jsonObject.put("reg_id", user.getReg_no());
            jsonObject.put("password", user.getPassword());
            jsonObject.put("profile_id",user.getProfile_id());
            jsonObject.put("clinic_id",user.getClinic_id());
            jsonObject.put("branch_id",user.getBranch_id());
            jsonObject.put("doctor_id",user.getDoctor_id());
            data.put("branch", jsonObject);

        }


        return data.toString();
    }

    @RequestMapping(value = "/EditDoctor", method = RequestMethod.POST)
    public
    @ResponseBody
    String editDoctor(@RequestBody DoctorUser doctorUser, HttpServletRequest request) throws JSONException{

        boolean flag;
        flag=doctorService.editDoctor(doctorUser);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("status",flag);
        return jsonObject.toString();
    }


    @RequestMapping(value = "/validate/{contact_no}", method = RequestMethod.GET)
    public
    @ResponseBody
    String validate(@PathVariable String contact_no) throws JSONException {

        boolean satus;
        JSONObject data = new JSONObject();
        List<Branch> validateClinic;

        validateClinic = clinicService.validateno(contact_no);
        if (validateClinic.isEmpty()) {
            data.put("status", true);
        } else {
            data.put("status", false);
        }

        return data.toString();
    }

    @RequestMapping(value = "/validateChief/{contact_no}", method = RequestMethod.GET)
    public
    @ResponseBody
    String validateChief(@PathVariable String contact_no) throws JSONException {


        JSONObject data = new JSONObject();
        List<Profile> validateContact;
        validateContact = profileService.validateno(contact_no);
        if (validateContact.isEmpty()) {
            data.put("status", true);
        } else {
            data.put("status", false);
        }


        return data.toString();
    }

    @RequestMapping(value = "/valName/{clinic_name}", method = RequestMethod.GET)
    public
    @ResponseBody
    String valName(@PathVariable String clinic_name) throws JSONException {

        JSONObject data = new JSONObject();
        List<Clinic> validateName;
        validateName = clinicService.validateName(clinic_name);
        if (validateName.isEmpty()) {
            data.put("status", true);
        } else {

            data.put("status", false);
        }

        return data.toString();

    }

    @RequestMapping(value = "/EditName/{clinic_id}/{clinic_name}", method = RequestMethod.GET)
    public
    @ResponseBody
    String EditName(@PathVariable Integer clinic_id, @PathVariable String clinic_name) throws JSONException {

        JSONObject data = new JSONObject();
        List<Clinic> validateName;
        validateName = clinicService.validateName(clinic_name);
        if (validateName.isEmpty()) {
            data.put("status", true);
        } else {
            Iterator<Clinic> it = validateName.iterator();
            while (it.hasNext()) {
                Clinic validatename = it.next();
                if (clinic_id == validatename.getClinic_id()) {
                    data.put("status", true);
                } else {
                    data.put("status", false);
                }

            }

        }
        return data.toString();
    }

    @RequestMapping(value = "/EditEmail/{clinic_id}/{clinic_email:.+}", method = RequestMethod.GET)
    public
    @ResponseBody
    String EditEmail(@PathVariable Integer clinic_id, @PathVariable String clinic_email) throws JSONException {

        JSONObject data = new JSONObject();
        List<Branch> editEmail;

        editEmail = clinicService.email(clinic_email);
        if (editEmail.isEmpty()) {
            data.put("status", true);
        } else {
            Iterator<Branch> it = editEmail.iterator();
            while (it.hasNext()) {
                Branch emailValidate = it.next();

                if (clinic_id == emailValidate.getClinic_id()) {
                    data.put("status", true);
                } else {
                    data.put("status", false);
                }

            }

        }
        return data.toString();
    }

    @RequestMapping(value = "/validateEmail/{email:.+}", method = RequestMethod.GET)
    public
    @ResponseBody
    String validateEmail(@PathVariable String email) throws JSONException {
        JSONObject data = new JSONObject();
        List<Profile> validateEmail;
        validateEmail = profileService.validateEmail(email);
        if (validateEmail.isEmpty()) {
            data.put("status", true);
        } else {
            data.put("status", false);
        }

        return data.toString();
    }

    @RequestMapping(value = "/trackSession/{email:.+}", method = RequestMethod.GET)
    public
    @ResponseBody
    String trackSession(@PathVariable String email) throws JSONException {

        JSONObject data = new JSONObject();
        List<ClinicUser> emailValidate;
        emailValidate = clinicService.track_id(email);
        Iterator<ClinicUser> itr = emailValidate.iterator();
        while (itr.hasNext()) {
            ClinicUser cuser = itr.next();
            data.put("clinic_id", cuser.getClinic_id());
            data.put("branch_id", cuser.getBranch_id());
            data.put("clinic_name", cuser.getClinic_name());
            data.put("ho", cuser.getHo());
            data.put("branch_name", cuser.getBranch_name());
            data.put("status", true);
        }


        return data.toString();
    }

    @RequestMapping(value = "/EditChiefEmail/{chief_id}/{email_id:.+}", method = RequestMethod.GET)
    public
    @ResponseBody
    String EditChiefEmail(@PathVariable Integer chief_id, @PathVariable String email_id) throws JSONException {
        JSONObject data = new JSONObject();
        List<Profile> validateEmail;
        validateEmail = profileService.validateEmail(email_id);
        if (validateEmail.isEmpty()) {
            data.put("status", true);
        } else {
            Iterator<Profile> it = validateEmail.iterator();
            while (it.hasNext()) {
                Profile emailChief = it.next();
                if (chief_id == emailChief.getProfile_id()) {
                    data.put("status", true);
                } else {
                    data.put("status", false);
                }
            }

        }

        return data.toString();
    }

    @RequestMapping(value = "/emailvalidate/{email_id:.+}", method = RequestMethod.GET)
    public
    @ResponseBody
    String emailvalidate(@PathVariable String email_id) throws JSONException {
        JSONObject datajson = new JSONObject();
        List<Branch> emailValidate;

        emailValidate = clinicService.email(email_id);
        if (emailValidate.isEmpty()) {
            datajson.put("status", true);
        } else {
            datajson.put("status", false);
        }

        return datajson.toString();
    }


    @RequestMapping(value = "/EditChiefContact/{chief_id}/{cihef_contactno}", method = RequestMethod.GET)
    public
    @ResponseBody
    String validateId(@PathVariable Integer chief_id, @PathVariable String cihef_contactno) throws JSONException {
        JSONObject data = new JSONObject();
        List<Profile> validateContact;
        validateContact = profileService.validateno(cihef_contactno);

        if (validateContact.isEmpty()) {
            data.put("status", true);
        } else {
            Iterator<Profile> it = validateContact.iterator();
            while (it.hasNext()) {
                Profile validateNo = it.next();

                if (validateNo.getProfile_id() == chief_id) {
                    data.put("status", true);
                } else {
                    data.put("status", false);
                }
            }
        }
        return data.toString();
    }

    @RequestMapping(value = "/emailvalidate/{email_id:.+}/{clinicID}", method = RequestMethod.GET)
    public
    @ResponseBody
    String emailvalidateId(@PathVariable String email_id, @PathVariable Integer clinicID) throws JSONException {
        JSONObject datajson = new JSONObject();
        List<Branch> emailValidate;

        emailValidate = clinicService.email(email_id);
        if (emailValidate.isEmpty()) {
            datajson.put("status", true);
        } else {
            Iterator<Branch> it = emailValidate.iterator();
            while (it.hasNext()) {
                Branch validateEmail = it.next();
                if (validateEmail.getClinic_id() == clinicID) {
                    datajson.put("status", true);
                } else {
                    datajson.put("status", false);
                }
            }

        }

        return datajson.toString();
    }

    @RequestMapping(value = "/DeleteClinic/{clinicID}", method = RequestMethod.DELETE)
    public
    @ResponseBody
    String deleteClinic(@PathVariable Integer clinicID) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        boolean deleteClinic;
        deleteClinic = clinicService.deleteclinic(clinicID);
        jsonObject.put("status", deleteClinic);
        return jsonObject.toString();
    }

}
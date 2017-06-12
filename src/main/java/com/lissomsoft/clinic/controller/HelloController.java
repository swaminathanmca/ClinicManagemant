package com.lissomsoft.clinic.controller;

import com.lissomsoft.clinic.domain.Speciality;
import com.lissomsoft.clinic.service.*;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.lissomsoft.clinic.domain.*;
import com.lissomsoft.clinic.vo.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Iterator;
import java.util.List;
import java.util.jar.JarEntry;


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
    @Autowired(required = false)
    private PatientService patientService;
    @Autowired(required = false)
    private SpecialityService specialityService;
    @Autowired(required = false)
    private ComplaintService complaintService;
    @Autowired(required = false)
    private PatientInfoService patientInfoService;
    @Autowired(required = false)
    private MedicineService medicineService;
    @Autowired(required = false)
    private PrescriptionService prescriptionService;
    @Autowired(required = false)
    private ServicesService servicesService;
    @Autowired(required = false)
    private InvestigationService investigationService;
    @Autowired(required = false)
    private LaboratoryService laboratoryService;
    @Autowired(required = false)
    private LabInvestigationService labInvestigationService;

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

    @RequestMapping(value = "/DoctorDashboard")
    public String doctordashboard(HttpServletRequest request) throws Exception{
        return "doctorDashboard";
    }
    @RequestMapping(value = "/GetBranch")
    public String getBranch(HttpServletRequest request) throws Exception {
        return "viewBranch";
    }

    @RequestMapping(value = "/GetClinic")
    public String getClinic(HttpServletRequest request) throws Exception {
        return "viewClinic";
    }

    @RequestMapping(value = "/GetPatient")
    public String getPatient(HttpServletRequest request)throws Exception{

        return "viewPatient";
    }

    @RequestMapping(value = "/clinicDetails")
    public String clinicDetails(HttpServletRequest request) throws Exception {
        return "clinicDetails";
    }

    @RequestMapping(value = "/doctorDetail")
    public String doctorDetails(HttpServletRequest request) throws Exception {
        return "doctorDetails";
    }

    @RequestMapping(value = "/patientDetail")
    public String patientDetails(HttpServletRequest request)throws Exception{
        return "patientDetails";
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
    public String addFrontdesk(HttpServletRequest request) throws Exception {
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
    public String viewFrontdesk(HttpServletRequest request) throws Exception {

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

    @RequestMapping(value = "/AddSpeciality")
    public String addSpeciality(HttpServletRequest request) throws Exception {
        return "speciality";
    }

    @RequestMapping(value = "/FrontDeskDetail")
    public String frontDeskdetail(HttpServletRequest request) throws Exception {
        return "FrontDesk";
    }

    @RequestMapping(value = "/ViewSpeciality")
    public String viewSpeciality(HttpServletRequest request) throws Exception{
        return "viewSpeciality";
    }

    @RequestMapping(value = "/ViewPatientVisit")
    public String viewPatientVisit(HttpServletRequest request)throws Exception{
        return "viewVisit";
    }
    @RequestMapping(value="/AddComplaint")
    public String addComplaint(HttpServletRequest request)throws Exception{
        return "addComplaint";
    }
    @RequestMapping(value = "/AddMedicine")
    public String addMedicine(HttpServletRequest request)throws Exception{
        return "Addmedicine";
    }

@RequestMapping (value = "/ViewComplaint")
  public String viewComplaint(HttpServletRequest request)throws Exception{
    return "viewComplaint";
    }

    @RequestMapping (value = "/patientComplaints")
    public String patientComplaints(HttpServletRequest request)throws Exception{
        return "patientComplaints";
    }

    @RequestMapping (value = "/patientHistory")
    public String patientHistory(HttpServletRequest request)throws Exception{

        return "patientHistory";
    }

    @RequestMapping(value = "/GetMedicine")
    public String getMedicine(HttpServletRequest request)throws Exception{
        return "viewMedicine";
    }

    @RequestMapping(value = "/AddPrescription")
    public String addPrescription(HttpServletRequest request)throws Exception{
        return "addPrescription";
    }

    @RequestMapping(value = "/AddInvestigation")
    public String addInvestigation(HttpServletRequest request)throws Exception{
        return "investigation";
    }


    @RequestMapping(value = "/AddService")
    public String addService(HttpServletRequest request)throws Exception{
        return "addService";
    }

    @RequestMapping(value = "/ViewService")
    public String viewService(HttpServletRequest request)throws Exception {
        return "viewServices";
    }

    @RequestMapping(value = "/AddLaboratory")
    public String addLaboratory(HttpServletRequest request)throws Exception{
        return "addLaboratory";
    }

    @RequestMapping(value = "/Invoice")
    public String invoice(HttpServletRequest request)throws Exception{
        return "invoice";
    }

    @RequestMapping(value = "/PatientFollowup")
    public String patientFollowup(HttpServletRequest request)throws Exception{
        return "patientFollowup";
    }

    @RequestMapping(value = "/PatientReport")
    public String patientReport(HttpServletRequest request)throws Exception{
        return "patientReport";
    }

    @RequestMapping(value = "/DetailsReport")
    public String detailsReport(HttpServletRequest request)throws Exception{
        return "detailsReport";
    }

    @RequestMapping(value = "/ViewLaboratory")
    public String viewLaboratory(HttpServletRequest request)throws Exception{
        return "viewLaboratory";
    }

    @RequestMapping(value = "/PatientTest")
    public String addTest(HttpServletRequest request)throws Exception{
        return "addTest";
    }

    @RequestMapping(value = "/EditpatientComplaint")
    public String editPatientComplaint(HttpServletRequest request)throws Exception{
        return "EditPatientComplaint";
    }

    @RequestMapping(value = "/SignIn", method = RequestMethod.POST)
    public
    @ResponseBody
    String signin(@RequestBody User user, HttpServletRequest request) throws JSONException {

        HttpSession session = request.getSession();


        String message = "Enter Correct Username And Password";
        List<User> userList;
        JSONObject jsonObject = new JSONObject();
        JSONObject data = new JSONObject();
        JSONObject status = new JSONObject();

        userList = userService.authenticateUser(user.getEmail_id(), encryptPassword(user.getPassword()));

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

    @RequestMapping(value = "/AddMedicine",method = RequestMethod.POST)
    public
    @ResponseBody
    String addMedicine(@RequestBody Medicine medicine)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        boolean flag;
        flag=medicineService.addMedicine(medicine);
        jsonObject.put("status",flag);
        return jsonObject.toString();
    }


    @RequestMapping(value = "/PatientVisit",method = RequestMethod.POST)
    public
    @ResponseBody
    String patientVisit(@RequestBody PatientVisit visit,HttpServletRequest request)throws JSONException{

        JSONObject jsonObject=new JSONObject();
        boolean flag;
        flag=patientService.patientEntry(visit);
        jsonObject.put("status",flag);
        return jsonObject.toString();
    }



    @RequestMapping(value = "/AddPatient/{branch_id}",method = RequestMethod.POST)
    public
    @ResponseBody
    String addPatient(@RequestBody Patient patient,@PathVariable Integer  branch_id,HttpServletRequest request)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        boolean flag;
        flag=patientService.addPatient(patient, branch_id);
        jsonObject.put("status",flag);

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




    private String encryptPassword(String password) {
        String passwordToHash = password;
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // Add password bytes to digest
            md.update(passwordToHash.getBytes());
            // Get the hash's bytes
            byte[] bytes = md.digest();
            // This bytes[] has bytes in decimal format;
            // Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            // Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return generatedPassword;
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

    @RequestMapping(value = "/AddService",method = RequestMethod.POST)
    public
    @ResponseBody
    String addService(@RequestBody Service service,HttpServletRequest request)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        boolean flag;
        flag=servicesService.addService(service);
        jsonObject.put("status",flag);
        return jsonObject.toString();
    }


    @RequestMapping(value = "/AddFrontDesk", method = RequestMethod.POST)
    public
    @ResponseBody
    String addFrontDesk(@RequestBody DoctorUser frontdesk, HttpServletRequest request) throws JSONException {

        JSONObject data = new JSONObject();
        boolean flag;
        flag = doctorService.addFrontdesk(frontdesk);
        data.put("status", flag);

        return data.toString();
    }

   @RequestMapping(value = "/AddSpeciality",method = RequestMethod.POST)
   public
   @ResponseBody
   String addSpeciality(@RequestBody Speciality speciality,HttpServletRequest request)throws JSONException{

       JSONObject data=new JSONObject();
       boolean flag;

        flag=specialityService.addSpeciality(speciality);
       data.put("status",flag);
       return data.toString();
   }

   @RequestMapping(value = "/AddComplaint",method = RequestMethod.POST)
   public
   @ResponseBody
   String addComplaint(@RequestBody Complaint complaint,HttpServletRequest request)throws  JSONException{
       JSONObject data=new JSONObject();
       boolean flag;

       flag=complaintService.addcomplaint(complaint);
        data.put("status",flag);
       return data.toString();
   }

    @RequestMapping(value = "/AddPatientPrescription",method = RequestMethod.POST)
    public
    @ResponseBody
    String AddPatientPrescription(@RequestBody Prescripe prescriptions,HttpServletRequest request)throws JSONException{
        JSONObject data=new JSONObject();
        boolean flag;
        flag=prescriptionService.addPrescription(prescriptions);
        data.put("status",flag);

        return data.toString();
    }


    @RequestMapping(value = "/patientInfo",method = RequestMethod.POST)
    public
    @ResponseBody
    String PatientInfo(@RequestBody PatientInfo patientInfo,HttpServletRequest request)throws JSONException{
        boolean flag;

        flag= patientInfoService.addpatientinfo(patientInfo);
        JSONObject data=new JSONObject();
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


    @RequestMapping(value = "/GetInfoId/{patient_pid}/{created_at}/{type}/{doctor_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String getInfoId(@PathVariable String patient_pid,@PathVariable String created_at,@PathVariable String type,@PathVariable Integer doctor_id)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        PatientInfo patientInfo;
        patientInfo=patientInfoService.getPatientInfoId(patient_pid,created_at,type,doctor_id);
        jsonObject.put("patient_info_id",patientInfo.getPatient_info_id());

        return jsonObject.toString();
    }


    @RequestMapping(value = "/EditPatient",method = RequestMethod.POST)
    public
    @ResponseBody
    String editPatient(@RequestBody Patient patient,HttpServletRequest request)throws JSONException{
        JSONObject jsonObject = new JSONObject();
        boolean flag;

        flag = patientService.editPatient(patient);
        jsonObject.put("status", flag);
        return jsonObject.toString();
    }


    @RequestMapping(value = "/EditPrescription",method = RequestMethod.POST)
    public
    @ResponseBody
    String editPrescription(@RequestBody Prescription prescription,HttpServletRequest request)throws JSONException{
        JSONObject jsonObject = new JSONObject();
        boolean flag;

        flag = prescriptionService.editPrescription(prescription);
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
            jsonObject.put("branch_id",clinicdetails.getBranch_id());
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

    @RequestMapping(value = "/ViewDoctor/{branch_id}/{clinic_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String viewDoctor(@PathVariable String branch_id,@PathVariable String clinic_id) throws Exception {

        List<Profile> viewDoctor;
        if(branch_id.equalsIgnoreCase("ALL")){

            viewDoctor=doctorService.viewAllDoctor(clinic_id);
        }else{
            viewDoctor = doctorService.viewDoctor(branch_id);
        }

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

    @RequestMapping(value = "/GetSpeciality",method = RequestMethod.GET)
    public
    @ResponseBody
    String getSpeciality(HttpServletRequest request)throws  JSONException{

        JSONArray jsonArray=new JSONArray();
        JSONObject data=new JSONObject();
        List<Speciality> getSpeciality;
        getSpeciality=specialityService.viewSpeciality();
        Iterator<Speciality> it=getSpeciality.iterator();
        while (it.hasNext()){
            JSONObject jsonObject=new JSONObject();
            Speciality speciality=it.next();
            jsonObject.put("speciallity_id",speciality.getSpeciallity_id());
            jsonObject.put("speciality_name",speciality.getSpeciality_name());
            jsonObject.put("description",speciality.getDescription());
            jsonArray.put(jsonObject);
            data.put("speciality",jsonArray);
        }


        return data.toString();
    }




    @RequestMapping(value = "/GetComplaint/{visit_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String getComplaint(@PathVariable String  visit_id,HttpServletRequest request)throws JSONException {

        JSONObject jsonObject = new JSONObject();
        JSONObject data=new JSONObject();
        PatientComplaint patientcomplaint;
        patientcomplaint=complaintService.patientcomplaint(visit_id);
        String dob[]=patientcomplaint.getDob().split("-");
        Integer dyear=Integer.parseInt(dob[2]);
        Integer dmonth=Integer.parseInt(dob[0]);
        Integer ddyas=Integer.parseInt(dob[1]);

        LocalDate birthday=LocalDate.of(dyear,dmonth,ddyas);
        LocalDate now=LocalDate.now();
        Period p=Period.between(birthday,now);

        if(p.getYears()>=1){
            jsonObject.put("age",p.getYears()+"  Years");
        }else{
            jsonObject.put("age",p.getMonths()+"  Months"+p.getDays()+"  Days");
        }

        jsonObject.put("patient_pid",patientcomplaint.getPatient_pid());
        jsonObject.put("patient_id",patientcomplaint.getPatient_id());
        jsonObject.put("first_name",patientcomplaint.getFirst_name());
        jsonObject.put("last_name",patientcomplaint.getLast_name());
        jsonObject.put("gender",patientcomplaint.getGender());
        jsonObject.put("weight",patientcomplaint.getWeight());
        jsonObject.put("type",patientcomplaint.getType());
        jsonObject.put("height",patientcomplaint.getHeight());
        jsonObject.put("pressure",patientcomplaint.getPressure());
        jsonObject.put("refereal_details",patientcomplaint.getComplaint_name());
        jsonObject.put("created_at",patientcomplaint.getCreated_at());
        jsonObject.put("doctor_id",patientcomplaint.getDoctor_detail_id());
        data.put("patientcomplaint",jsonObject);
        return data.toString();
    }

    @RequestMapping(value = "/SpecialityDetail/{speciality_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String specialityDetails(@PathVariable Integer speciality_id  ,HttpServletRequest request)throws JSONException {

        JSONObject jsonObject=new JSONObject();
        Speciality speciality;
        speciality=specialityService.specialityDetails(speciality_id);
        jsonObject.put("speciality_id",speciality.getSpeciallity_id());
        jsonObject.put("speciality_name",speciality.getSpeciality_name());
        jsonObject.put("description",speciality.getDescription());

        return jsonObject.toString();
    }
    @RequestMapping(value = "/GetComplaint",method = RequestMethod.GET)
    public
    @ResponseBody
    String getcomplaint(HttpServletRequest request)throws JSONException {
        JSONArray jsonArray=new JSONArray();
        JSONObject data=new JSONObject();
        List<Complaint> getComplaint;
        getComplaint=complaintService.ViewComplaint();
        Iterator<Complaint>it=getComplaint.iterator();
        while (it.hasNext()){
            JSONObject jsonObject=new JSONObject();
            Complaint complaint=it.next();
            jsonObject.put("complaint_id",complaint.getComplaint_id());
            jsonObject.put("complaint_name",complaint.getComplaint_name());
            jsonObject.put("complaint_description",complaint.getComplaint_description());
            jsonArray.put(jsonObject);
            data.put("complaint",jsonArray);
        }
        return data.toString();

    }
    @RequestMapping(value = "/ComplaintDetail/{complaint_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String viewdeatil(@PathVariable Integer complaint_id ,HttpServletRequest request)throws JSONException{
        JSONObject jsonobject=new JSONObject();
        Complaint complaint;
        complaint=complaintService.ComplaintDetail(complaint_id);
        jsonobject.put("complaint_id",complaint.getComplaint_id());
        jsonobject.put("complaint_name",complaint.getComplaint_name());
        jsonobject.put("complaint_description",complaint.getComplaint_description());
        return jsonobject.toString();
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

    @RequestMapping(value = "/ViewBranchAdmin/{clinic_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String viewBranchAdmin(@PathVariable Integer clinic_id) throws Exception {
        JSONArray jsonArray = new JSONArray();
        JSONObject sendResponse = new JSONObject();
        List<Branch> branchDetails;
        branchDetails = branchService.getBranch(clinic_id);
        Iterator<Branch> it = branchDetails.iterator();
        while (it.hasNext()) {
            Branch branch = it.next();
            if (branch.getHo() == 0) {
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

    @RequestMapping(value = "/ViewFrontdesk/{branch_id}/{clinic_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String viewFrontDesk(@PathVariable String branch_id,@PathVariable Integer clinic_id) throws Exception {
        JSONArray jsonArray = new JSONArray();
        JSONObject data = new JSONObject();
        List<Profile> frontDesk;
        if (branch_id.equalsIgnoreCase("ALL")) {
            frontDesk = doctorService.viewFrontDeskAll(clinic_id);
        }else {frontDesk = doctorService.viewFrontDesk(branch_id);}
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
            data.put("user", jsonArray);}
            return data.toString();}

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
            jsonObject.put("clinic_name",branch.getClinic_name());
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
        JSONArray specalityArray=new JSONArray();
        List<DoctorUser> doctorDetails;
        DoctorUser doctorUser = doctorService.doctorDetails(profile_id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",doctorUser.getFirstname());
        jsonObject.put("address1", doctorUser.getAddress1());
        jsonObject.put("address2", doctorUser.getAddress2());
        jsonObject.put("city", doctorUser.getCity());
        jsonObject.put("state", doctorUser.getState());
        jsonObject.put("country", doctorUser.getCountry());
        jsonObject.put("pincode", doctorUser.getPincode());
        jsonObject.put("gender", doctorUser.getGender());
        jsonObject.put("email", doctorUser.getEmail_id());
        jsonObject.put("phone", doctorUser.getContact_no());
        jsonObject.put("clinic_id",doctorUser.getClinic_id());
        jsonObject.put("clinic_name", doctorUser.getClinic_name());
        jsonObject.put("qualification", doctorUser.getQualification());
        jsonObject.put("specialization", doctorUser.getSpecialization());
        jsonObject.put("charges",doctorUser.getCharge());
        jsonObject.put("reg_id", doctorUser.getReg_no());
        jsonObject.put("password", doctorUser.getPassword());
        jsonObject.put("profile_id", doctorUser.getProfile_id());
        jsonObject.put("doctor_id", doctorUser.getDoctor_id());

        List<Branch> branches=doctorUser.getBranch();
        Iterator<Branch> it=branches.iterator();
        while (it.hasNext()){
            Branch branch=it.next();
            JSONObject branchObject=new JSONObject();
            branchObject.put("address1",branch.getAddress1());
            branchObject.put("address2",branch.getAddress2());
            branchObject.put("branch_id",branch.getBranch_id());
            branchObject.put("branch_name",branch.getBranch_name());
            branchObject.put("contact_no",branch.getContact_no());
            branchObject.put("description",branch.getDescripton());
            jsonArray.put(branchObject);
        }
        List<Speciality> specialities=doctorUser.getSpecialization();
        Iterator<Speciality> itr=specialities.iterator();
        while (itr.hasNext()){
            Speciality special=itr.next();
            JSONObject specailityObject=new JSONObject();
            specailityObject.put("speciallity_id",special.getSpeciallity_id());
            specailityObject.put("speciality_name",special.getSpeciality_name());
            specailityObject.put("description",special.getDescription());
            specalityArray.put(specailityObject);
        }

        jsonObject.put("specialization",specalityArray);
        jsonObject.put("branches",jsonArray);
        data.put("branch",jsonObject);

        return data.toString();
    }

    @RequestMapping(value = "/ViewPatient/{branch_id}/{clinic_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String viewpatient(@PathVariable String branch_id,@PathVariable Integer clinic_id )throws Exception{
        JSONArray jsonArray = new JSONArray();
        JSONObject data = new JSONObject();
        List<Patient> getdetails;
       /* if (branch_id.equalsIgnoreCase("ALL")) {
            getdetails = patientService.viewPatientAll(clinic_id);
        }else {getdetails = patientService.viewFrontDesk(branch_id);}*/
        getdetails=patientService.viewPatient(branch_id);
        Iterator<Patient> it=getdetails.iterator();
        while (it.hasNext()){
            JSONObject jsonObject=new JSONObject();
            Patient patient=it.next();
            jsonObject.put("patient_id",patient.getPatientId());
            jsonObject.put("patient_pid",patient.getPatient_pId());
            jsonObject.put("first_name",patient.getFullName());
            jsonObject.put("last_name",patient.getLastName());
            jsonObject.put("contact_no",patient.getContact_no());
            jsonObject.put("email",patient.getEmail());
            jsonArray.put(jsonObject);
            data.put("patient",jsonArray);

        }

        return data.toString();
    }

    @RequestMapping(value = "/frontdeskDetails/{profile_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String frontdeskDetails(@PathVariable Integer profile_id)throws Exception{
        JSONObject jsonObject=new JSONObject();
        JSONObject data=new JSONObject();
        DoctorUser doctorUser=doctorService.frontdeskDetails(profile_id);
        jsonObject.put("name",doctorUser.getFirstname());
        jsonObject.put("address1", doctorUser.getAddress1());
        jsonObject.put("address2", doctorUser.getAddress2());
        jsonObject.put("city", doctorUser.getCity());
        jsonObject.put("state", doctorUser.getState());
        jsonObject.put("country", doctorUser.getCountry());
        jsonObject.put("pincode", doctorUser.getPincode());
        jsonObject.put("gender", doctorUser.getGender());
        jsonObject.put("email", doctorUser.getEmail_id());
        jsonObject.put("phone", doctorUser.getContact_no());
        jsonObject.put("clinic_id",doctorUser.getClinic_id());
        jsonObject.put("clinic_name", doctorUser.getClinic_name());
        jsonObject.put("branch_id",doctorUser.getBranch_id());
        jsonObject.put("branch_name",doctorUser.getBranch_name());
        jsonObject.put("qualification", doctorUser.getQualification());
        jsonObject.put("profile_id", doctorUser.getProfile_id());
        jsonObject.put("doctor_id", doctorUser.getDoctor_id());
        data.put("frontdesk",jsonObject);

         return  data.toString();
    }

    @RequestMapping(value = "/patientDetails/{patient_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String patientDetails(@PathVariable Integer patient_id)throws Exception{
        JSONObject jsonObject=new JSONObject();
        JSONObject data=new JSONObject();
        Patient patient=patientService.patientdetails(patient_id);
        String dob[]=patient.getDob().split("/");
        Integer dyear=Integer.parseInt(dob[2]);
        Integer dmonth=Integer.parseInt(dob[0]);
        Integer ddyas=Integer.parseInt(dob[1]);
        LocalDate birthday=LocalDate.of(dyear,dmonth,ddyas);
        LocalDate now=LocalDate.now();
        Period p=Period.between(birthday,now);
        if(p.getYears()>=1){
            jsonObject.put("age",p.getYears()+"  Years");
        }else{
            jsonObject.put("age",p.getMonths()+"  Months"+p.getDays()+"  Days");
        }
        jsonObject.put("first_name",patient.getFullName());
        jsonObject.put("last_name",patient.getLastName());
        jsonObject.put("address1",patient.getAddress1());
        jsonObject.put("address2",patient.getAddress2());
        jsonObject.put("dob",patient.getDob());
        jsonObject.put("city",patient.getCity());
        jsonObject.put("state",patient.getState());
        jsonObject.put("country",patient.getCountry());
        jsonObject.put("pincode",patient.getPincode());
        jsonObject.put("contact_no",patient.getContact_no());
        jsonObject.put("mobile_no",patient.getResidental_no());
        jsonObject.put("gender",patient.getGender());
        jsonObject.put("blood_group",patient.getBloodGroup());
        jsonObject.put("mstatus",patient.getmStatus());
        jsonObject.put("email",patient.getEmail());
        jsonObject.put("patient_pid",patient.getPatient_pId());
        jsonObject.put("patient_id",patient.getPatientId());
        jsonObject.put("name",patient.getEmergency_name());
        jsonObject.put("relation",patient.getRelation());
        jsonObject.put("emr_address1",patient.getEmergency_address1());
        jsonObject.put("emr_address2",patient.getEmergency_address2());
        jsonObject.put("emr_city",patient.getEmergency_city());
        jsonObject.put("emr_state",patient.getEmergency_state());
        jsonObject.put("emr_country",patient.getEmergency_country());
        jsonObject.put("emr_pincode",patient.getEmergency_pincode());
        jsonObject.put("emr_contact_no",patient.getEmergency_contact_no());
        jsonObject.put("emr_mobile_no",patient.getEmergency_residental_no());
        jsonObject.put("email_id",patient.getEmergency_email());
        jsonObject.put("referred_by",patient.getReferred_by());
        jsonObject.put("allergy_food",patient.getAllergy_food());
        jsonObject.put("allergy_others",patient.getAllergy_others());
        jsonObject.put("status",true);

        return jsonObject.toString();
    }

    @RequestMapping(value = "/EditDoctor", method = RequestMethod.POST)
    public
    @ResponseBody
    String editDoctor(@RequestBody DoctorUser doctorUser, HttpServletRequest request) throws JSONException {

        boolean flag;
        flag = doctorService.editDoctor(doctorUser);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", flag);
        return jsonObject.toString();
    }

        @RequestMapping(value ="/EditComplaint/{complaint_id}",method = RequestMethod.POST)
        public
        @ResponseBody
        String editcomplaint(@RequestBody Complaint complaint,@PathVariable Integer complaint_id,HttpServletRequest request)throws JSONException{
         JSONObject jsonObject=new JSONObject();
            boolean flag;
            flag=complaintService.editcomplaint(complaint,complaint_id);

        jsonObject.put("status",flag);

    return jsonObject.toString();

}


    @RequestMapping(value = "/EditSpeciality/{speciality_id}",method = RequestMethod.POST)
    public
    @ResponseBody
    String editSpeciality(@RequestBody Speciality speciality,@PathVariable Integer speciality_id,HttpServletRequest request)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        boolean flag;
        flag=specialityService.editSpeciality(speciality,speciality_id);
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

    @RequestMapping(value = "/EditContact/{branch_id}/{contact_no}",method = RequestMethod.GET)
    public
    @ResponseBody
    String EditContact(@PathVariable Integer branch_id,@PathVariable String contact_no)throws JSONException{
        JSONObject data=new JSONObject();
        List<Branch> validateNo;
        validateNo=clinicService.validateno(contact_no);

        if(validateNo.isEmpty()){
            data.put("status",true);
        }else{
            Iterator<Branch> it=validateNo.iterator();
            while (it.hasNext()){
                Branch validateNumber=it.next();
                if(branch_id==validateNumber.getBranch_id()){
                    data.put("status",true);
                }else{
                    data.put("status",false);
                }
            }
        }
        return data.toString();
    }

    @RequestMapping(value = "/EditEmail/{branch_id}/{clinic_email:.+}", method = RequestMethod.GET)
    public
    @ResponseBody
    String EditEmail(@PathVariable Integer branch_id, @PathVariable String clinic_email) throws JSONException {

        JSONObject data = new JSONObject();
        List<Branch> editEmail;

        editEmail = clinicService.email(clinic_email);
        if (editEmail.isEmpty()) {
            data.put("status", true);
        } else {
            Iterator<Branch> it = editEmail.iterator();
            while (it.hasNext()) {
                Branch emailValidate = it.next();

                if (branch_id == emailValidate.getBranch_id()) {
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



    @RequestMapping(value = "/trackSessionBranch/{email:.+}",method = RequestMethod.GET)
    public
    @ResponseBody
    String trackSessionBranch(@PathVariable String email) throws JSONException{
        JSONObject jsonObject=new JSONObject();
        List<Doctor> trackDetails;
        trackDetails=doctorService.trackSeason(email);
        Iterator<Doctor> itr=trackDetails.iterator();
        while (itr.hasNext()){
            Doctor track=itr.next();
            jsonObject.put("clinic_id",track.getClinic_id());
            jsonObject.put("branch_id",track.getBranch_id());
            jsonObject.put("doctor_id",track.getDoctor_id());
            jsonObject.put("status",true);
        }


     return  jsonObject.toString();
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


    @RequestMapping(value = "/BloodGroup",method = RequestMethod.GET)
    public
    @ResponseBody
    String bloodgroup(HttpServletRequest request)throws JSONException{

        JSONArray jsonArray=new JSONArray();
        JSONObject data=new JSONObject();
        List<Blood> bloodDetails;
        bloodDetails=patientService.bloodtypeDetails();
        Iterator<Blood> it=bloodDetails.iterator();
        while (it.hasNext()){
            Blood getDetails=it.next();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("blood_id",getDetails.getBlood_id());
            jsonObject.put("blood_type",getDetails.getBlood_type());
            jsonArray.put(jsonObject);

        }
        data.put("blood",jsonArray);

        return data.toString();

    }

    @RequestMapping(value = "/ViewMedicine",method = RequestMethod.GET)
    public
    @ResponseBody
    String viewMedicine()throws JSONException{
        JSONArray jsonArray=new JSONArray();
        JSONObject data=new JSONObject();
        List<Medicine> medicineList;
        medicineList=medicineService.getMedicine();
        Iterator<Medicine> it=medicineList.iterator();
        while (it.hasNext()){
            Medicine getMedicine=it.next();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("medicine_id",getMedicine.getMedicine_id());
            jsonObject.put("medicine_name",getMedicine.getMedicine_name());
            jsonObject.put("mg",getMedicine.getMg());
            jsonObject.put("type",getMedicine.getType());
            jsonObject.put("vendor",getMedicine.getVendor());
            jsonArray.put(jsonObject);
        }

        data.put("medicines",jsonArray);
        return data.toString();
    }


    @RequestMapping(value = "/ValidatePatient/{contact_no}",method = RequestMethod.GET)
    public
    @ResponseBody
    String validatePatient(@PathVariable String contact_no,HttpServletRequest request)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        List<Patient> validateNo;
        validateNo=patientService.validatePatient(contact_no);
        if(validateNo.isEmpty()){
            jsonObject.put("status",true);
        }else{
            jsonObject.put("status",false);
        }


        return jsonObject.toString();
    }

    @RequestMapping(value = "/Doctorname/{speciallity_id}/{branch_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String doctordetails(@PathVariable String speciallity_id,@PathVariable String branch_id,HttpServletRequest request)throws JSONException{
       JSONObject data=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        List<DoctorUser> specialities;
        specialities=doctorService.doctorspecailities(speciallity_id,branch_id);
        Iterator<DoctorUser> it=specialities.iterator();
        while (it.hasNext()){
            DoctorUser profile=it.next();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("profile_id",profile.getProfile_id());
            jsonObject.put("profile_name",profile.getFirstname());
            jsonObject.put("doctor_id",profile.getDoctor_id());
            jsonArray.put(jsonObject);
        }
        data.put("profile",jsonArray);


      return data.toString();
    }

    @RequestMapping(value = "MedicineDetails/{medicine_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String medicineDetails(@PathVariable Integer medicine_id)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        Medicine medicineDetails=new Medicine();
        medicineDetails=medicineService.medicineDetails(medicine_id);
        jsonObject.put("medicine_id",medicineDetails.getMedicine_id());
        jsonObject.put("medicine_name",medicineDetails.getMedicine_name());
        jsonObject.put("mg",medicineDetails.getMg());
        jsonObject.put("type",medicineDetails.getType());
        jsonObject.put("vendor",medicineDetails.getVendor());

        return jsonObject.toString();
    }

    @RequestMapping(value = "/EditMedicine")
    public
    @ResponseBody
    String editMedicine(@RequestBody Medicine medicine)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        boolean flag;
        flag=medicineService.editMedicine(medicine);
        jsonObject.put("status",flag);
        return jsonObject.toString();
    }

    @RequestMapping(value = "patientHistory/{doctor_id}/{branch_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String patientHistory(@PathVariable Integer doctor_id,@PathVariable Integer branch_id)throws JSONException{

        JSONObject data=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        List<PatientInfo> patientInfos;
        patientInfos=patientInfoService.getPatientInfo(doctor_id,branch_id);
        Iterator<PatientInfo> it=patientInfos.iterator();
        while (it.hasNext()) {
            PatientInfo patientinfo = it.next();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("patient_pid", patientinfo.getPatient_pid());
            jsonObject.put("first_name", patientinfo.getFirst_name());
            jsonObject.put("last_name", patientinfo.getLast_name());
            jsonObject.put("date", patientinfo.getDate());
            jsonObject.put("referal_details",patientinfo.getRefereal_details());
            jsonArray.put(jsonObject);
        }

        data.put("patientinfo",jsonArray);

        return data.toString();
    }


    @RequestMapping(value = "/ViewPatientVisit/{branch_id}/{doctor_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String viewPatientVisit(@PathVariable String branch_id,@PathVariable String doctor_id,HttpServletRequest request)throws JSONException{
        JSONObject data=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        List<PatientVisit> PatientVisit;
        if(doctor_id.equalsIgnoreCase("ALL")){

            PatientVisit=patientService.patientEntryAll(branch_id);

        }else{
            PatientVisit = patientService.patientEntry(doctor_id,branch_id);
        }

        Iterator<PatientVisit> it=PatientVisit.iterator();
        while (it.hasNext()){
            PatientVisit visit=it.next();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("first_name",visit.getFirst_name());
            jsonObject.put("last_name",visit.getLast_name());
            jsonObject.put("patient_pid",visit.getPatient_pid());
            jsonObject.put("entry_time",visit.getTime());
            jsonObject.put("referal_details",visit.getReferal_details());
            jsonArray.put(jsonObject);

        }
        data.put("patient",jsonArray);
      return    data.toString();
    }

    @RequestMapping(value = "ViewDoctorBranch/{branch_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String viewDoctor(@PathVariable String branch_id,HttpServletRequest request)throws  JSONException{
        JSONObject data=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        List<DoctorUser> doctorUsers;
        doctorUsers=doctorService.getDoctor(branch_id);
        Iterator<DoctorUser> itr=doctorUsers.iterator();
        while (itr.hasNext()){
            DoctorUser doctorvisit=itr.next();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("profile_id",doctorvisit.getProfile_id());
            jsonObject.put("profile_name",doctorvisit.getFirstname());
            jsonObject.put("doctor_id",doctorvisit.getDoctor_id());
            jsonArray.put(jsonObject);

        }
        data.put("user",jsonArray);
        return data.toString();
    }

    @RequestMapping(value = "PrescriptionType/{type}",method = RequestMethod.GET)
    public
    @ResponseBody
    String prescriptionType(@PathVariable Integer type,HttpServletRequest request)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        List<Medicine> medicinesTypes;
        medicinesTypes=medicineService.getMedicineType(type);
        Iterator<Medicine> it=medicinesTypes.iterator();
        while (it.hasNext()){
            Medicine medicine=it.next();
            JSONObject data=new JSONObject();
            data.put("medicine_id",medicine.getMedicine_id());
            data.put("medicine_name",medicine.getMedicine_name());
            data.put("mg",medicine.getMg());
            jsonArray.put(data);
        }
        jsonObject.put("medicines",jsonArray);

        return jsonObject.toString();
    }



    @RequestMapping(value="ShowPatient/{branch_id}/{doctor_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String showpatient(@PathVariable String branch_id,@PathVariable String doctor_id,HttpServletRequest request)throws JSONException{
        JSONObject data = new JSONObject();
        JSONArray jsonArray=new JSONArray();
        List<PatientVisit> patientvisits;
        patientvisits= patientService.patientEntry(doctor_id, branch_id);

        Iterator<PatientVisit> it=patientvisits.iterator();
        while (it.hasNext()){
            PatientVisit visit=it.next();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("visit_id",visit.getVisit_id());
            jsonObject.put("first_name",visit.getFirst_name());
            jsonObject.put("last_name",visit.getLast_name());
            jsonObject.put("patient_pid",visit.getPatient_pid());
            jsonObject.put("entry_time",visit.getTime());
            jsonObject.put("referal_details",visit.getReferal_details());
            jsonObject.put("type",visit.getHeight());
            jsonArray.put(jsonObject);

        }
        data.put("patient",jsonArray);
        return data.toString();
    }



    @RequestMapping(value = "/GetServices",method = RequestMethod.GET)
    public
    @ResponseBody
    String getServices(HttpServletRequest request)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        List<Service> services;
        services=servicesService.getServices();
        Iterator<Service> it=services.iterator();
        while (it.hasNext()){
            Service ser=it.next();
            JSONObject data=new JSONObject();
            data.put("service_id",ser.getService_id());
            data.put("service_name",ser.getService_name());
            data.put("description",ser.getDescription());
            data.put("charges",ser.getCharges());
            jsonArray.put(data);
        }
        jsonObject.put("services",jsonArray);
        return jsonObject.toString();
    }

    @RequestMapping(value = "/ServiceDetails/{service_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String serviceDetails(@PathVariable Integer service_id,HttpServletRequest request)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        Service service;
        service=servicesService.serviceDetails(service_id);
        jsonObject.put("service_name",service.getService_name());
        jsonObject.put("service_id",service.getService_id());
        jsonObject.put("description",service.getDescription());
        jsonObject.put("charges",service.getCharges());
        jsonObject.put("status",true);

        return jsonObject.toString();
    }

    @RequestMapping(value = "/EditService",method = RequestMethod.POST)
    public
    @ResponseBody
    String editService(@RequestBody Service service,HttpServletRequest request)throws JSONException{

        JSONObject jsonObject=new JSONObject();
        boolean flag;
        flag=servicesService.editService(service);
        jsonObject.put("status",flag);
        return jsonObject.toString();

    }

    @RequestMapping(value = "/GetPrescription/{patient_info_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String getPrescription(@PathVariable Integer patient_info_id,HttpServletRequest request )throws JSONException{

        JSONObject jsonObject=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        List<Prescription> prescriptions;
        prescriptions=prescriptionService.getPrescription(patient_info_id);
        Iterator<Prescription> it=prescriptions.iterator();
        while (it.hasNext()){
            Prescription pres=it.next();
            JSONObject data=new JSONObject();
            data.put("prescription_id",pres.getPrescription_id());
            data.put("medicine_id",pres.getMedicine_id());
            data.put("medicine_name",pres.getMedicine_name());
            data.put("mg",pres.getMg());
            data.put("patient_info_id",pres.getPatient_info_id());
            data.put("frequency",pres.getFrequency());
            data.put("mrg_qty",pres.getMrg_qty());
            data.put("aft_qty",pres.getAft_qty());
            data.put("ngt_qty",pres.getNig_qty());
            data.put("days",pres.getDays());
            data.put("remarks",pres.getRemarks());
            data.put("day1",pres.getDays1());
            data.put("day2",pres.getDays2());
            data.put("day3",pres.getDays3());
            data.put("day4",pres.getDays4());
            data.put("day5",pres.getDays5());
            data.put("day6",pres.getDays6());
            data.put("day7",pres.getDays7());
            jsonArray.put(data);
        }

        jsonObject.put("prescription",jsonArray);
        return jsonObject.toString();
    }

    @RequestMapping(value = "/RemovePrescription",method = RequestMethod.POST)
    public
    @ResponseBody
    String removePrescription(@RequestBody Prescripe Prescription,HttpServletRequest request)throws JSONException{
        JSONObject jsonObject=new JSONObject();

        boolean flag;
        flag=prescriptionService.removeprescription(Prescription);
        jsonObject.put("status",flag);

        return jsonObject.toString();
    }

    @RequestMapping(value = "/GetPrescriptionbyId/{prescription_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String getprescriptionById(@PathVariable Integer prescription_id,HttpServletRequest request)throws  JSONException{

        JSONObject jsonObject=new JSONObject();
        Prescription prescription;
        prescription=prescriptionService.getPrescriptionById(prescription_id);
        jsonObject.put("medicine_name",prescription.getMedicine_name());
        jsonObject.put("medicine_id",prescription.getMedicine_id());
        jsonObject.put("prescription_id",prescription.getPrescription_id());
        jsonObject.put("mrg_qty",prescription.getMrg_qty());
        jsonObject.put("aft_qty",prescription.getAft_qty());
        jsonObject.put("ngt_qty",prescription.getNig_qty());
        jsonObject.put("days",prescription.getDays());
        jsonObject.put("frequency",prescription.getFrequency());
        jsonObject.put("remarks",prescription.getRemarks());
        jsonObject.put("type",prescription.getType());
        jsonObject.put("day1",prescription.getDays1());
        jsonObject.put("day2",prescription.getDays2());
        jsonObject.put("day3",prescription.getDays3());
        jsonObject.put("day4",prescription.getDays4());
        jsonObject.put("day5",prescription.getDays5());
        jsonObject.put("day6",prescription.getDays6());
        jsonObject.put("day7",prescription.getDays7());
        return jsonObject.toString();
    }


    @RequestMapping(value = "/DoctorDetailCharges/{doctor_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String doctorDetailCharges(@PathVariable Integer doctor_id,HttpServletRequest request)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        DoctorUser doctorUser;
        doctorUser=doctorService.getDoctorCharges(doctor_id);
        jsonObject.put("charges",doctorUser.getCharge());

        return jsonObject.toString();
    }


    @RequestMapping(value = "/AddInvestigation",method = RequestMethod.POST)
    public
    @ResponseBody
    String addInvestigation(@RequestBody Investigation investigation,HttpServletRequest request)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        boolean flag;
        flag=investigationService.addInvestigation(investigation);
        jsonObject.put("status",flag);
        return jsonObject.toString();
    }

    @RequestMapping(value = "/GetDoctorProfile/{doctor_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String getDoctorProfile(@PathVariable Integer doctor_id,HttpServletRequest request)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        DoctorUser profile;
        profile=doctorService.getDoctorprofile(doctor_id);
        jsonObject.put("name",profile.getFirstname());
        jsonObject.put("address1",profile.getAddress1());
        jsonObject.put("email",profile.getEmail_id());
        jsonObject.put("qualification",profile.getQualification());


        return jsonObject.toString();
    }


    @RequestMapping(value = "/GetInvestigation/{visit_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String getInvestigation(@PathVariable Integer visit_id,HttpServletRequest request)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        Investigation investigation;
        List<InvestServices> investServices;
        investigation=investigationService.getCharges(visit_id);
        jsonObject.put("total_amount",investigation.getTotal_amount());
        jsonObject.put("status",true);
        investServices=investigation.getInvestServices();
        Iterator<InvestServices> it=investServices.iterator();
        while (it.hasNext()){
            InvestServices investServices1=it.next();
            JSONObject data=new JSONObject();
            data.put("charges",investServices1.getCharges());
            data.put("discount",investServices1.getDiscount());
            data.put("service_name",investServices1.getService_name());
            jsonArray.put(data);
        }

        jsonObject.put("services",jsonArray);


        return jsonObject.toString();
    }

    @RequestMapping(value = "/GetEntryNew/{patient_pid}/{type}/{doctor_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String getEntryNew(@PathVariable String patient_pid,@PathVariable Integer type,@PathVariable Integer doctor_id,HttpServletRequest request)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        List<PatientVisit> patientVisit;
        boolean flag;
        patientVisit=patientService.getEntryNew(patient_pid,type,doctor_id);
        if(patientVisit.isEmpty()){
            jsonObject.put("status",true);
        }else{
            jsonObject.put("status",false);
        }



        return jsonObject.toString();
    }

    @RequestMapping(value = "/GetPatientInfo/{patient_pid}/{doctor_id}/{branch_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String getpatientInfo(@PathVariable String patient_pid,@PathVariable Integer doctor_id,@PathVariable Integer branch_id,HttpServletRequest request)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        PatientInfo patientInfo;
        List<Complaint> complaints;
        patientInfo=patientInfoService.getPatientFollow(patient_pid,doctor_id,branch_id);
        jsonObject.put("procedures",patientInfo.getProcedures());
        jsonObject.put("diagonics",patientInfo.getDiagnosis());
        jsonObject.put("observation",patientInfo.getObservation());
        jsonObject.put("investigation",patientInfo.getInvestigation());
        jsonObject.put("patient_info_id",patientInfo.getPatient_info_id());
        complaints=patientInfo.getComplaint();
        Iterator<Complaint> itr=complaints.iterator();
        while (itr.hasNext()){
            Complaint complaint= itr.next();
            JSONObject data=new JSONObject();
            data.put("complaint_name",complaint.getComplaint_name());
            data.put("complaint_description",complaint.getComplaint_description());
            data.put("complaint_id",complaint.getComplaint_id());
            jsonArray.put(data);
        }
        jsonObject.put("complaints",jsonArray);

        return jsonObject.toString();
    }

    @RequestMapping(value = "/EditPatientInfo",method = RequestMethod.POST)
    public
    @ResponseBody
    String editPatientInfo(@RequestBody PatientInfo patientInfo,HttpServletRequest request)throws JSONException
    {
        JSONObject jsonObject=new JSONObject();
        boolean flag;

        flag=patientInfoService.editPatientInfo(patientInfo);
        jsonObject.put("status",flag);
        return jsonObject.toString();
    }


    @RequestMapping(value = "/GetFollowUp/{patient_pid}/{doctor_id}/{type}",method = RequestMethod.GET)
    public
    @ResponseBody
    String getFollowUp(@PathVariable String patient_pid,@PathVariable Integer doctor_id,@PathVariable Integer type,HttpServletRequest request)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        boolean flag;
        List<PatientVisit> patientVisits;
        patientVisits=patientService.getEntryFollowup(patient_pid,doctor_id,type);
        if(patientVisits.isEmpty()){
            jsonObject.put("status",true);
        }else{
            jsonObject.put("status",false);
        }


        return jsonObject.toString();
    }

    @RequestMapping(value = "/GetPatientInfoReport/{patient_pid}/{from_date}/{to_date}/{doctor_id}/{branch_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String getPatientReport(@PathVariable String patient_pid,@PathVariable String from_date,@PathVariable String to_date,@PathVariable Integer doctor_id,@PathVariable Integer branch_id,HttpServletRequest request)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        List<PatientReport> patientInfos;
        patientInfos=patientInfoService.getPatientReport(patient_pid,from_date,to_date,doctor_id,branch_id);
        Iterator<PatientReport> it=patientInfos.iterator();
        while (it.hasNext()){
            PatientReport patientReport=it.next();
            JSONObject data=new JSONObject();
            data.put("first_name",patientReport.getFirst_name());
            data.put("last_name",patientReport.getLast_name());
            data.put("pateint_info_id",patientReport.getPatient_info_id());
            data.put("referal_details",patientReport.getReferal_details());
            data.put("created_at",patientReport.getDate());
            data.put("patient_pid",patientReport.getPatient_pid());
            jsonArray.put(data);
        }
        jsonObject.put("report",jsonArray);
        return jsonObject.toString();
    }

    @RequestMapping(value = "/GetPatientReportByMonths/{patient_pid}/{date}/{doctor_id}/{branch_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String getpatientReportByMonths(@PathVariable String patient_pid,@PathVariable String date,@PathVariable Integer doctor_id,@PathVariable Integer branch_id,HttpServletRequest request)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        List<PatientReport> patientInfos;
        patientInfos=patientInfoService.getPatientReportByMonths(patient_pid, date, doctor_id, branch_id);
        Iterator<PatientReport> it=patientInfos.iterator();
        while (it.hasNext()){
            PatientReport patientReport=it.next();
            JSONObject data=new JSONObject();
            data.put("first_name",patientReport.getFirst_name());
            data.put("last_name",patientReport.getLast_name());
            data.put("pateint_info_id",patientReport.getPatient_info_id());
            data.put("referal_details",patientReport.getReferal_details());
            data.put("created_at",patientReport.getDate());
            data.put("patient_pid",patientReport.getPatient_pid());
            jsonArray.put(data);
        }
        jsonObject.put("report",jsonArray);


        return jsonObject.toString();
    }

    @RequestMapping(value = "/GetInfoDetails/{patient_info_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String getInfoDetails(@PathVariable Integer patient_info_id,HttpServletRequest request)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        PatientReport patientReport;
        List<Complaint>complaints;
        patientReport=patientInfoService.getInfoDetails(patient_info_id);

        jsonObject.put("first_name",patientReport.getFirst_name());
        jsonObject.put("last_name",patientReport.getLast_name());
        jsonObject.put("diagonics",patientReport.getDiagonics());
        jsonObject.put("procedures",patientReport.getProcedures());
        jsonObject.put("patient_pid",patientReport.getPatient_pid());
        jsonObject.put("observation",patientReport.getObservation());
        jsonObject.put("investigation",patientReport.getInvestigation());
        jsonObject.put("type",patientReport.getType());
        jsonObject.put("bp",patientReport.getBp());
        jsonObject.put("created_at",patientReport.getDate());
        complaints=patientReport.getComplaints();
        Iterator<Complaint> itr=complaints.iterator();
        while (itr.hasNext()){
            Complaint complaint=itr.next();
            JSONObject data=new JSONObject();
            data.put("complaint_id",complaint.getComplaint_id());
            data.put("complaint_name",complaint.getComplaint_name());
            data.put("complaint_description",complaint.getComplaint_description());
            jsonArray.put(data);
        }
        jsonObject.put("complaints",jsonArray);
        return  jsonObject.toString();
    }


    @RequestMapping(value = "/AddLaboratory",method = RequestMethod.POST)
    public
    @ResponseBody
    String addLaboratory(@RequestBody Laboratory laboratory)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        boolean flag;
        flag=laboratoryService.addLaboratory(laboratory);
        jsonObject.put("status",flag);

        return jsonObject.toString();
    }

    @RequestMapping(value = "/GetLaboratory",method = RequestMethod.GET)
    public
    @ResponseBody
    String getLaboratory(HttpServletRequest request)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        List<Laboratory> laboratories;
        laboratories=laboratoryService.getLaboratory();
        Iterator<Laboratory> it=laboratories.iterator();
        while (it.hasNext()){
            Laboratory laboratory=it.next();
            JSONObject data=new JSONObject();
            data.put("test_id",laboratory.getTest_id());
            data.put("test_type",laboratory.getTest_type());
            data.put("test_name",laboratory.getTest_name());
            data.put("description",laboratory.getDescription());
            jsonArray.put(data);
        }
        jsonObject.put("laboratory",jsonArray);
        return jsonObject.toString();
    }

    @RequestMapping(value = "/GetLaboratoryId/{test_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String getLaboratoryId(@PathVariable Integer test_id,HttpServletRequest request)throws JSONException{

        JSONObject jsonObject=new JSONObject();
        Laboratory laboratory=new Laboratory();
        laboratory=laboratoryService.getLaboratoryId(test_id);
        jsonObject.put("test_id",laboratory.getTest_id());
        jsonObject.put("test_type",laboratory.getTest_type());
        jsonObject.put("test_name",laboratory.getTest_name());
        jsonObject.put("description",laboratory.getDescription());
        return  jsonObject.toString();
    }
    @RequestMapping(value = "/EditLaboratoryId",method = RequestMethod.POST)
    public
    @ResponseBody
    String  editLaboratoryId(@RequestBody Laboratory laboratory,HttpServletRequest request)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        boolean flag;
        flag=laboratoryService.editLaboratory(laboratory);
        jsonObject.put("status",flag);
        return jsonObject.toString();

    }

    @RequestMapping(value = "/LabType",method = RequestMethod.GET)
    public
    @ResponseBody
    String getLabtype(HttpServletRequest request)throws JSONException{
        JSONArray jsonArray=new JSONArray();
        JSONObject jsonObject=new JSONObject();
        List<Laboratory> laboratories;
        laboratories=laboratoryService.TypeLab();
        Iterator<Laboratory> it=laboratories.iterator();
        while (it.hasNext()){
            Laboratory laboratory=it.next();
            JSONObject data=new JSONObject();
            data.put("test_type",laboratory.getTest_type());
            jsonArray.put(data);
        }
        jsonObject.put("laboratory",jsonArray);


        return jsonObject.toString();

    }

    @RequestMapping(value = "/LaboratoryType/{test_type}",method = RequestMethod.GET)
    public
    @ResponseBody
    String laboratoryType(@PathVariable String test_type)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        List<Laboratory> laboratoryList;
        laboratoryList=laboratoryService.getLaboratoryType(test_type);
        Iterator<Laboratory> it=laboratoryList.iterator();
        while (it.hasNext()){
            Laboratory laboratory=it.next();
            JSONObject data=new JSONObject();
            data.put("test_id",laboratory.getTest_id());
            data.put("test_name",laboratory.getTest_name());
            jsonArray.put(data);
        }
        jsonObject.put("laboratory",jsonArray);


        return  jsonObject.toString();


    }
    @RequestMapping(value = "/AddLabReferences",method = RequestMethod.POST)
    public
    @ResponseBody
    String addLabreferences(@RequestBody LabInvestigation labInvestigation)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        boolean flag;
        flag=labInvestigationService.addLabInvestigation(labInvestigation);
        jsonObject.put("status",flag);

        return  jsonObject.toString();

    }
    @RequestMapping(value = "/GetLabInvest/{patient_info_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String getLabInvest(@PathVariable Integer patient_info_id,HttpServletRequest request)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        List<LabInvestigation> labInvestigationList;
        labInvestigationList=labInvestigationService.getInvestigation(patient_info_id);
        Iterator<LabInvestigation> it=labInvestigationList.iterator();
        while (it.hasNext()){
            LabInvestigation labInvestigation=it.next();
            JSONObject data=new JSONObject();
            data.put("test_type",labInvestigation.getTest_type());
            data.put("test_name",labInvestigation.getTest_name());
            data.put("remarks",labInvestigation.getRemarks());
            data.put("investigation_id",labInvestigation.getLabinvestigation_id());
            jsonArray.put(data);
        }
        jsonObject.put("labinvest",jsonArray);

        return  jsonObject.toString();
    }

    @RequestMapping(value = "/RemoveLabInvest/{investigation_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String removeLabInvest(@PathVariable Integer investigation_id,HttpServletRequest request)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        boolean flag;

        flag=labInvestigationService.removeLabInvestigation(investigation_id);
        jsonObject.put("status",flag);
        return  jsonObject.toString();
    }


    @RequestMapping(value = "/GetLabInvestigationId/{investigation_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String getLabInvestigationId(@PathVariable Integer investigation_id,HttpServletRequest request)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        LabInvestigation labInvestigation=new LabInvestigation();
        labInvestigation=labInvestigationService.getLabInvestigation(investigation_id);
        jsonObject.put("labinvestigation_id",labInvestigation.getLabinvestigation_id());
        jsonObject.put("test_type",labInvestigation.getTest_type());
        jsonObject.put("test_name",labInvestigation.getTest_name());
        jsonObject.put("remarks",labInvestigation.getRemarks());



        return  jsonObject.toString();
    }

    @RequestMapping(value = "/GetLabtype/{test_name}",method = RequestMethod.GET)
    public
    @ResponseBody
    String getLabTypes(@PathVariable String test_name,HttpServletRequest request)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        Laboratory laboratory=new Laboratory();
        laboratory=laboratoryService.getLabType(test_name);
        jsonObject.put("test_type",laboratory.getTest_type());
        jsonObject.put("test_id",laboratory.getTest_id());
        jsonObject.put("desc",laboratory.getDescription());

        return  jsonObject.toString();
    }
    @RequestMapping(value = "/EditLabInvestigation",method = RequestMethod.POST)
    public
    @ResponseBody
    String editLabInvestigation(@RequestBody LabInvestigation labInvestigation)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        Boolean flag;
        flag=labInvestigationService.editlabInvestigation(labInvestigation);
        jsonObject.put("status",flag);

        return jsonObject.toString();
    }

    @RequestMapping(value = "/GetFollowUpWeek/{patient_pid}/{type}/{doctor_id}/{date}",method = RequestMethod.GET)
    public
    @ResponseBody
    String getFollowupWeek(@PathVariable String patient_pid,@PathVariable Integer type,@PathVariable Integer doctor_id,@PathVariable String date)throws JSONException{
        JSONObject jsonObject=new JSONObject();
       List<PatientVisit> patientVisits;
        patientVisits=patientService.getFollowUp(patient_pid,type,doctor_id,date);
        if(patientVisits.isEmpty()){
            jsonObject.put("status",false);
        }else{
            jsonObject.put("status",true);
        }

        return jsonObject.toString();
    }

    @RequestMapping(value = "/GetAllEntry/{patient_pid}/{doctor_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String getAllEntry(@PathVariable String patient_pid,@PathVariable Integer doctor_id)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        List<PatientVisit> patientVisits;
        patientVisits=patientService.getAllEntry(patient_pid,doctor_id);
        if(patientVisits.isEmpty()){
            jsonObject.put("status",false);
        }else{
            jsonObject.put("status",true);
        }


        return jsonObject.toString();
    }

}
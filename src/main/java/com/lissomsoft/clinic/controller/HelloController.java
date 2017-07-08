package com.lissomsoft.clinic.controller;

import com.lissomsoft.clinic.domain.Speciality;
import com.lissomsoft.clinic.rowmapper.UserLogin;
import com.lissomsoft.clinic.service.*;
import javafx.util.converter.TimeStringConverter;
import jdk.nashorn.api.scripting.JSObject;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.lissomsoft.clinic.domain.*;
import com.lissomsoft.clinic.vo.*;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.Date;
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
    @Autowired(required = false)
    private AppointmentService appointmentService;
    @Autowired(required = false)
    private ScheduleService scheduleService;
    @Autowired(required = false)
    private NewAppointmentService newAppointmentService;

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
    public String doctordashboard(HttpServletRequest request) throws Exception {
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
    public String getPatient(HttpServletRequest request) throws Exception {

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
    public String patientDetails(HttpServletRequest request) throws Exception {
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
    public String viewSpeciality(HttpServletRequest request) throws Exception {
        return "viewSpeciality";
    }

    @RequestMapping(value = "/ViewPatientVisit")
    public String viewPatientVisit(HttpServletRequest request) throws Exception {
        return "viewVisit";
    }

    @RequestMapping(value = "/AddComplaint")
    public String addComplaint(HttpServletRequest request) throws Exception {
        return "addComplaint";
    }

    @RequestMapping(value = "/AddMedicine")
    public String addMedicine(HttpServletRequest request) throws Exception {
        return "Addmedicine";
    }

    @RequestMapping(value = "/ViewComplaint")
    public String viewComplaint(HttpServletRequest request) throws Exception {
        return "viewComplaint";
    }

    @RequestMapping(value = "/patientComplaints")
    public String patientComplaints(HttpServletRequest request) throws Exception {
        return "patientComplaints";
    }

    @RequestMapping(value = "/patientHistory")
    public String patientHistory(HttpServletRequest request) throws Exception {

        return "patientHistory";
    }

    @RequestMapping(value = "/GetMedicine")
    public String getMedicine(HttpServletRequest request) throws Exception {
        return "viewMedicine";
    }

    @RequestMapping(value = "/AddPrescription")
    public String addPrescription(HttpServletRequest request) throws Exception {
        return "addPrescription";
    }

    @RequestMapping(value = "/AddInvestigation")
    public String addInvestigation(HttpServletRequest request) throws Exception {
        return "investigation";
    }


    @RequestMapping(value = "/AddService")
    public String addService(HttpServletRequest request) throws Exception {
        return "addService";
    }

    @RequestMapping(value = "/ViewService")
    public String viewService(HttpServletRequest request) throws Exception {
        return "viewServices";
    }

    @RequestMapping(value = "/AddLaboratory")
    public String addLaboratory(HttpServletRequest request) throws Exception {
        return "addLaboratory";
    }

    @RequestMapping(value = "/Invoice")
    public String invoice(HttpServletRequest request) throws Exception {
        return "invoice";
    }

    @RequestMapping(value = "/PatientFollowup")
    public String patientFollowup(HttpServletRequest request) throws Exception {
        return "patientFollowup";
    }

    @RequestMapping(value = "/PatientReport")
    public String patientReport(HttpServletRequest request) throws Exception {
        return "patientReport";
    }

    @RequestMapping(value = "/DetailsReport")
    public String detailsReport(HttpServletRequest request) throws Exception {
        return "detailsReport";
    }

    @RequestMapping(value = "/ViewLaboratory")
    public String viewLaboratory(HttpServletRequest request) throws Exception {
        return "viewLaboratory";
    }

    @RequestMapping(value = "/PatientTest")
    public String addTest(HttpServletRequest request) throws Exception {
        return "addTest";
    }

    @RequestMapping(value = "/EditpatientComplaint")
    public String editPatientComplaint(HttpServletRequest request) throws Exception {
        return "EditPatientComplaint";
    }


    @RequestMapping(value = "/AddAppointment")
    public String addAppointment(HttpServletRequest request) throws Exception {
        return "appointment";
    }

    @RequestMapping(value = "/ViewAppointment")
    public String viewAppointment(HttpServletRequest request) throws Exception {
        return "viewAppointment";
    }

    @RequestMapping(value = "/AddSchedule")
    public String addSchedule(HttpServletRequest request) throws Exception {
        return "addSchedule";
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

    @RequestMapping(value = "/AddMedicine", method = RequestMethod.POST)
    public
    @ResponseBody
    String addMedicine(@RequestBody Medicine medicine) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        boolean flag;
        flag = medicineService.addMedicine(medicine);
        jsonObject.put("status", flag);
        return jsonObject.toString();
    }


    @RequestMapping(value = "/PatientVisit", method = RequestMethod.POST)
    public
    @ResponseBody
    String patientVisit(@RequestBody PatientVisit visit, HttpServletRequest request) throws JSONException {

        JSONObject jsonObject = new JSONObject();
        boolean flag;
        flag = patientService.patientEntry(visit);
        jsonObject.put("status", flag);
        return jsonObject.toString();
    }


    @RequestMapping(value = "/AddPatient/{branch_id}", method = RequestMethod.POST)
    public
    @ResponseBody
    String addPatient(@RequestBody Patient patient, @PathVariable Integer branch_id, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        boolean flag;
        flag = patientService.addPatient(patient, branch_id);
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

    @RequestMapping(value = "/AddService/{branch_id}", method = RequestMethod.POST)
    public
    @ResponseBody
    String addService(@RequestBody Service service, HttpServletRequest request, @PathVariable Integer branch_id) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        boolean flag;
        flag = servicesService.addService(service, branch_id);
        jsonObject.put("status", flag);
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

    @RequestMapping(value = "/AddSpeciality", method = RequestMethod.POST)
    public
    @ResponseBody
    String addSpeciality(@RequestBody Speciality speciality, HttpServletRequest request) throws JSONException {

        JSONObject data = new JSONObject();
        boolean flag;

        flag = specialityService.addSpeciality(speciality);
        data.put("status", flag);
        return data.toString();
    }

    @RequestMapping(value = "/AddComplaint", method = RequestMethod.POST)
    public
    @ResponseBody
    String addComplaint(@RequestBody Complaint complaint, HttpServletRequest request) throws JSONException {
        JSONObject data = new JSONObject();
        boolean flag;

        flag = complaintService.addcomplaint(complaint);
        data.put("status", flag);
        return data.toString();
    }

    @RequestMapping(value = "/AddPatientPrescription", method = RequestMethod.POST)
    public
    @ResponseBody
    String AddPatientPrescription(@RequestBody Prescripe prescriptions, HttpServletRequest request) throws JSONException {
        JSONObject data = new JSONObject();
        boolean flag;
        flag = prescriptionService.addPrescription(prescriptions);
        data.put("status", flag);

        return data.toString();
    }


    @RequestMapping(value = "/patientInfo", method = RequestMethod.POST)
    public
    @ResponseBody
    String PatientInfo(@RequestBody PatientInfo patientInfo, HttpServletRequest request) throws JSONException {
        boolean flag;

        flag = patientInfoService.addpatientinfo(patientInfo);
        JSONObject data = new JSONObject();
        data.put("status", flag);
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

    @RequestMapping(value = "/AddAppointment", method = RequestMethod.POST)
    public
    @ResponseBody
    String addAppointment(@RequestBody Appointment appointment, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        boolean flag;
        appointment.setDov(appointment.getDov().replace("-","/"));

        flag = appointmentService.addAppointment(appointment);
        jsonObject.put("status", flag);
        return jsonObject.toString();
    }

    @RequestMapping(value = "/AddNewAppointment", method = RequestMethod.POST)
    public
    @ResponseBody
    String addnewappoinment(@RequestBody NewAppointment newAppointment, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        boolean flag;
        NewAppointment newAppointmentpid;
        newAppointmentpid = newAppointmentService.newapp();
        String preuId = "";
        String lastdigit = "";

        String cur_date, num1, date, year, uId;
        int nextVal;

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        cur_date = format.format(new Date());
        num1 = cur_date.replaceAll("/", "");
        date = num1.substring(0, 4);
        String nozero = num1.substring(4);
        year = nozero.replaceAll("0", "");
        String todate = num1.substring(0, 2);
        String fname = (newAppointment.getFirst_name().substring(0, 1)).toUpperCase();
        String lname = (newAppointment.getLast_name().substring(newAppointment.getLast_name().length() - 1)).toUpperCase();

        if (newAppointmentpid == null) {
            uId = "TP" + lname + fname + date + year + 1;
        } else {
            preuId = (newAppointmentpid.getNew_appointment_pid()).substring(4, 6);
            lastdigit = (newAppointmentpid.getNew_appointment_pid()).substring(11);
            int x = Integer.parseInt(lastdigit);

            if (todate.equals(preuId)) {
                nextVal = x + 1;
            } else {
                nextVal = 1;
            }
            uId = "TP" + lname + fname + date + year + nextVal;
        }

        flag = newAppointmentService.addnewappointment(newAppointment, uId);
        jsonObject.put("status", flag);

        return jsonObject.toString();
    }

    @RequestMapping(value = "/GetInfoId/{patient_pid}/{created_at}/{type}/{doctor_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String getInfoId(@PathVariable String patient_pid, @PathVariable String created_at, @PathVariable String type, @PathVariable Integer doctor_id) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        PatientInfo patientInfo;
        patientInfo = patientInfoService.getPatientInfoId(patient_pid, created_at, type, doctor_id);
        jsonObject.put("patient_info_id", patientInfo.getPatient_info_id());

        return jsonObject.toString();
    }

    @RequestMapping(value = "/PatientAppointmentInfo/{dob}/{contact_no}/{branch_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String getPatientInfo(@PathVariable String dob, @PathVariable String contact_no, @PathVariable Integer branch_id) throws JSONException {
        JSONObject data = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<Patient> appointmentInfos;
        List<NewAppointment> newAppointments;
        String date = dob.replace("-", "/");
        appointmentInfos = appointmentService.appoinmentInfo(branch_id, date, contact_no);

        if(appointmentInfos.isEmpty()){
            newAppointments=newAppointmentService.appoinmentInfo(branch_id,date,contact_no);

            Iterator<NewAppointment> itr=newAppointments.iterator();
            while (itr.hasNext()){
                JSONObject jsonObject=new JSONObject();
                NewAppointment newAppointment=itr.next();
                jsonObject.put("first_name", newAppointment.getFirst_name());
                jsonObject.put("last_name", newAppointment.getLast_name());
                jsonObject.put("address1", newAppointment.getAddress1());
                jsonObject.put("address2", newAppointment.getAddress2());
                jsonObject.put("contact_no",newAppointment.getMobile_no());
                jsonObject.put("patient_pId", newAppointment.getNew_appointment_pid());
                jsonObject.put("patient_id", newAppointment.getNew_appointment_id());
                jsonArray.put(jsonObject);
                data.put("patient", jsonArray);
            }



        }else{
            Iterator<Patient> it = appointmentInfos.iterator();
            while (it.hasNext()) {
                JSONObject jsonObject1 = new JSONObject();
                Patient patient = it.next();
                jsonObject1.put("first_name", patient.getFullName());
                jsonObject1.put("last_name", patient.getLastName());
                jsonObject1.put("address1", patient.getAddress1());
                jsonObject1.put("address2", patient.getAddress2());
                jsonObject1.put("contact_no",patient.getContact_no());
                jsonObject1.put("patient_pId", patient.getPatient_pId());
                jsonObject1.put("patient_id", patient.getPatientId());
                jsonArray.put(jsonObject1);
                data.put("patient", jsonArray);
            }
        }

        return data.toString();
    }

    @RequestMapping(value = "/EditPatient", method = RequestMethod.POST)
    public
    @ResponseBody
    String editPatient(@RequestBody Patient patient, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        boolean flag;

        flag = patientService.editPatient(patient);
        jsonObject.put("status", flag);
        return jsonObject.toString();
    }


    @RequestMapping(value = "/EditPrescription", method = RequestMethod.POST)
    public
    @ResponseBody
    String editPrescription(@RequestBody Prescription prescription, HttpServletRequest request) throws JSONException {
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
            jsonObject.put("branch_id", clinicdetails.getBranch_id());
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
    String viewDoctor(@PathVariable String branch_id, @PathVariable String clinic_id) throws Exception {

        List<Profile> viewDoctor;
        if (branch_id.equalsIgnoreCase("ALL")) {

            viewDoctor = doctorService.viewAllDoctor(clinic_id);
        } else {
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

    @RequestMapping(value = "/GetSpeciality", method = RequestMethod.GET)
    public
    @ResponseBody
    String getSpeciality(HttpServletRequest request) throws JSONException {

        JSONArray jsonArray = new JSONArray();
        JSONObject data = new JSONObject();
        List<Speciality> getSpeciality;
        getSpeciality = specialityService.viewSpeciality();
        Iterator<Speciality> it = getSpeciality.iterator();
        while (it.hasNext()) {
            JSONObject jsonObject = new JSONObject();
            Speciality speciality = it.next();
            jsonObject.put("speciallity_id", speciality.getSpeciallity_id());
            jsonObject.put("speciality_name", speciality.getSpeciality_name());
            jsonObject.put("description", speciality.getDescription());
            jsonArray.put(jsonObject);
            data.put("speciality", jsonArray);
        }


        return data.toString();
    }


    @RequestMapping(value = "/GetComplaint/{visit_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String getComplaint(@PathVariable String visit_id, HttpServletRequest request) throws JSONException {

        JSONObject jsonObject = new JSONObject();
        JSONObject data = new JSONObject();
        PatientComplaint patientcomplaint;
        patientcomplaint = complaintService.patientcomplaint(visit_id);
        String dob[] = patientcomplaint.getDob().split("/");
        Integer dyear = Integer.parseInt(dob[2]);
        Integer dmonth = Integer.parseInt(dob[0]);
        Integer ddyas = Integer.parseInt(dob[1]);

        LocalDate birthday = LocalDate.of(dyear, dmonth, ddyas);
        LocalDate now = LocalDate.now();
        Period p = Period.between(birthday, now);

        if (p.getYears() >= 1) {
            jsonObject.put("age", p.getYears() + "  Years");
        } else {
            jsonObject.put("age", p.getMonths() + "  Months" + p.getDays() + "  Days");
        }

        jsonObject.put("patient_pid", patientcomplaint.getPatient_pid());
        jsonObject.put("patient_id", patientcomplaint.getPatient_id());
        jsonObject.put("first_name", patientcomplaint.getFirst_name());
        jsonObject.put("last_name", patientcomplaint.getLast_name());
        jsonObject.put("gender", patientcomplaint.getGender());
        jsonObject.put("weight", patientcomplaint.getWeight());
        jsonObject.put("type", patientcomplaint.getType());
        jsonObject.put("height", patientcomplaint.getHeight());
        jsonObject.put("pressure", patientcomplaint.getPressure());
        jsonObject.put("refereal_details", patientcomplaint.getComplaint_name());
        jsonObject.put("created_at", patientcomplaint.getCreated_at());
        jsonObject.put("doctor_id", patientcomplaint.getDoctor_detail_id());
        data.put("patientcomplaint", jsonObject);
        return data.toString();
    }


    @RequestMapping(value = "/SpecialityDetail/{speciality_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String specialityDetails(@PathVariable Integer speciality_id, HttpServletRequest request) throws JSONException {

        JSONObject jsonObject = new JSONObject();
        Speciality speciality;
        speciality = specialityService.specialityDetails(speciality_id);
        jsonObject.put("speciality_id", speciality.getSpeciallity_id());
        jsonObject.put("speciality_name", speciality.getSpeciality_name());
        jsonObject.put("description", speciality.getDescription());

        return jsonObject.toString();
    }

    @RequestMapping(value = "/GetComplaint", method = RequestMethod.GET)
    public
    @ResponseBody
    String getcomplaint(HttpServletRequest request) throws JSONException {
        JSONArray jsonArray = new JSONArray();
        JSONObject data = new JSONObject();
        List<Complaint> getComplaint;
        getComplaint = complaintService.ViewComplaint();
        Iterator<Complaint> it = getComplaint.iterator();
        while (it.hasNext()) {
            JSONObject jsonObject = new JSONObject();
            Complaint complaint = it.next();
            jsonObject.put("complaint_id", complaint.getComplaint_id());
            jsonObject.put("complaint_name", complaint.getComplaint_name());
            jsonObject.put("complaint_description", complaint.getComplaint_description());
            jsonArray.put(jsonObject);
            data.put("complaint", jsonArray);
        }
        return data.toString();

    }

    @RequestMapping(value = "/ComplaintDetail/{complaint_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String viewdeatil(@PathVariable Integer complaint_id, HttpServletRequest request) throws JSONException {
        JSONObject jsonobject = new JSONObject();
        Complaint complaint;
        complaint = complaintService.ComplaintDetail(complaint_id);
        jsonobject.put("complaint_id", complaint.getComplaint_id());
        jsonobject.put("complaint_name", complaint.getComplaint_name());
        jsonobject.put("complaint_description", complaint.getComplaint_description());
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
    String viewFrontDesk(@PathVariable String branch_id, @PathVariable Integer clinic_id) throws Exception {
        JSONArray jsonArray = new JSONArray();
        JSONObject data = new JSONObject();
        List<Profile> frontDesk;
        if (branch_id.equalsIgnoreCase("ALL")) {
            frontDesk = doctorService.viewFrontDeskAll(clinic_id);
        } else {
            frontDesk = doctorService.viewFrontDesk(branch_id);
        }
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
            jsonObject.put("clinic_name", branch.getClinic_name());
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
        JSONArray specalityArray = new JSONArray();
        List<DoctorUser> doctorDetails;
        DoctorUser doctorUser = doctorService.doctorDetails(profile_id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", doctorUser.getFirstname());
        jsonObject.put("address1", doctorUser.getAddress1());
        jsonObject.put("address2", doctorUser.getAddress2());
        jsonObject.put("city", doctorUser.getCity());
        jsonObject.put("state", doctorUser.getState());
        jsonObject.put("country", doctorUser.getCountry());
        jsonObject.put("pincode", doctorUser.getPincode());
        jsonObject.put("gender", doctorUser.getGender());
        jsonObject.put("email", doctorUser.getEmail_id());
        jsonObject.put("phone", doctorUser.getContact_no());
        jsonObject.put("clinic_id", doctorUser.getClinic_id());
        jsonObject.put("clinic_name", doctorUser.getClinic_name());
        jsonObject.put("qualification", doctorUser.getQualification());
        jsonObject.put("specialization", doctorUser.getSpecialization());
        jsonObject.put("charges", doctorUser.getCharge());
        jsonObject.put("reg_id", doctorUser.getReg_no());
        jsonObject.put("password", doctorUser.getPassword());
        jsonObject.put("profile_id", doctorUser.getProfile_id());
        jsonObject.put("doctor_id", doctorUser.getDoctor_id());
        jsonObject.put("roomno",doctorUser.getRoomno());
        List<Branch> branches = doctorUser.getBranch();
        Iterator<Branch> it = branches.iterator();
        while (it.hasNext()) {
            Branch branch = it.next();
            JSONObject branchObject = new JSONObject();
            branchObject.put("address1", branch.getAddress1());
            branchObject.put("address2", branch.getAddress2());
            branchObject.put("branch_id", branch.getBranch_id());
            branchObject.put("branch_name", branch.getBranch_name());
            branchObject.put("contact_no", branch.getContact_no());
            branchObject.put("description", branch.getDescripton());
            jsonArray.put(branchObject);
        }
        List<Speciality> specialities = doctorUser.getSpecialization();
        Iterator<Speciality> itr = specialities.iterator();
        while (itr.hasNext()) {
            Speciality special = itr.next();
            JSONObject specailityObject = new JSONObject();
            specailityObject.put("speciallity_id", special.getSpeciallity_id());
            specailityObject.put("speciality_name", special.getSpeciality_name());
            specailityObject.put("description", special.getDescription());
            specalityArray.put(specailityObject);
        }

        jsonObject.put("specialization", specalityArray);
        jsonObject.put("branches", jsonArray);
        data.put("branch", jsonObject);

        return data.toString();
    }

    @RequestMapping(value = "/ViewPatient/{branch_id}/{clinic_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String viewpatient(@PathVariable String branch_id, @PathVariable Integer clinic_id) throws Exception {
        JSONArray jsonArray = new JSONArray();
        JSONObject data = new JSONObject();
        List<Patient> getdetails;
       /* if (branch_id.equalsIgnoreCase("ALL")) {
            getdetails = patientService.viewPatientAll(clinic_id);
        }else {getdetails = patientService.viewFrontDesk(branch_id);}*/
        getdetails = patientService.viewPatient(branch_id);
        Iterator<Patient> it = getdetails.iterator();
        while (it.hasNext()) {
            JSONObject jsonObject = new JSONObject();
            Patient patient = it.next();
            jsonObject.put("patient_id", patient.getPatientId());
            jsonObject.put("patient_pid", patient.getPatient_pId());
            jsonObject.put("first_name", patient.getFullName());
            jsonObject.put("last_name", patient.getLastName());
            jsonObject.put("contact_no", patient.getContact_no());
            jsonObject.put("email", patient.getEmail());
            jsonArray.put(jsonObject);
            data.put("patient", jsonArray);

        }

        return data.toString();
    }

    @RequestMapping(value = "/frontdeskDetails/{profile_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String frontdeskDetails(@PathVariable Integer profile_id) throws Exception {
        JSONObject jsonObject = new JSONObject();
        JSONObject data = new JSONObject();
        DoctorUser doctorUser = doctorService.frontdeskDetails(profile_id);
        jsonObject.put("name", doctorUser.getFirstname());
        jsonObject.put("address1", doctorUser.getAddress1());
        jsonObject.put("address2", doctorUser.getAddress2());
        jsonObject.put("city", doctorUser.getCity());
        jsonObject.put("state", doctorUser.getState());
        jsonObject.put("country", doctorUser.getCountry());
        jsonObject.put("pincode", doctorUser.getPincode());
        jsonObject.put("gender", doctorUser.getGender());
        jsonObject.put("email", doctorUser.getEmail_id());
        jsonObject.put("phone", doctorUser.getContact_no());
        jsonObject.put("clinic_id", doctorUser.getClinic_id());
        jsonObject.put("clinic_name", doctorUser.getClinic_name());
        jsonObject.put("branch_id", doctorUser.getBranch_id());
        jsonObject.put("branch_name", doctorUser.getBranch_name());
        jsonObject.put("qualification", doctorUser.getQualification());
        jsonObject.put("profile_id", doctorUser.getProfile_id());
        jsonObject.put("doctor_id", doctorUser.getDoctor_id());
        data.put("frontdesk", jsonObject);

        return data.toString();
    }

    @RequestMapping(value = "/patientDetails/{patient_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String patientDetails(@PathVariable Integer patient_id) throws Exception {
        JSONObject jsonObject = new JSONObject();
        JSONObject data = new JSONObject();
        Patient patient = patientService.patientdetails(patient_id);
        String dob[] = patient.getDob().split("/");
        Integer dyear = Integer.parseInt(dob[2]);
        Integer dmonth = Integer.parseInt(dob[0]);
        Integer ddyas = Integer.parseInt(dob[1]);
        LocalDate birthday = LocalDate.of(dyear, dmonth, ddyas);
        LocalDate now = LocalDate.now();
        Period p = Period.between(birthday, now);
        if (p.getYears() >= 1) {
            jsonObject.put("age", p.getYears() + "  Years");
        } else {
            jsonObject.put("age", p.getMonths() + "  Months" + p.getDays() + "  Days");
        }
        jsonObject.put("first_name", patient.getFullName());
        jsonObject.put("last_name", patient.getLastName());
        jsonObject.put("address1", patient.getAddress1());
        jsonObject.put("address2", patient.getAddress2());
        jsonObject.put("dob", patient.getDob());
        jsonObject.put("city", patient.getCity());
        jsonObject.put("state", patient.getState());
        jsonObject.put("country", patient.getCountry());
        jsonObject.put("pincode", patient.getPincode());
        jsonObject.put("contact_no", patient.getContact_no());
        jsonObject.put("mobile_no", patient.getResidental_no());
        jsonObject.put("gender", patient.getGender());
        jsonObject.put("blood_group", patient.getBloodGroup());
        jsonObject.put("mstatus", patient.getmStatus());
        jsonObject.put("email", patient.getEmail());
        jsonObject.put("patient_pid", patient.getPatient_pId());
        jsonObject.put("patient_id", patient.getPatientId());
        jsonObject.put("name", patient.getEmergency_name());
        jsonObject.put("relation", patient.getRelation());
        jsonObject.put("emr_address1", patient.getEmergency_address1());
        jsonObject.put("emr_address2", patient.getEmergency_address2());
        jsonObject.put("emr_city", patient.getEmergency_city());
        jsonObject.put("emr_state", patient.getEmergency_state());
        jsonObject.put("emr_country", patient.getEmergency_country());
        jsonObject.put("emr_pincode", patient.getEmergency_pincode());
        jsonObject.put("emr_contact_no", patient.getEmergency_contact_no());
        jsonObject.put("emr_mobile_no", patient.getEmergency_residental_no());
        jsonObject.put("email_id", patient.getEmergency_email());
        jsonObject.put("referred_by", patient.getReferred_by());
        jsonObject.put("allergy_food", patient.getAllergy_food());
        jsonObject.put("allergy_others", patient.getAllergy_others());
        jsonObject.put("status", true);

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

    @RequestMapping(value = "/EditFrontDesk",method = RequestMethod.POST)
    public
    @ResponseBody
    String editFrontDesk(@RequestBody DoctorUser doctorUser,HttpServletRequest request)throws JSONException{
        boolean flag;
        flag=doctorService.editFrontDesk(doctorUser);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", flag);
        return jsonObject.toString();
    }



    @RequestMapping(value = "/EditComplaint/{complaint_id}", method = RequestMethod.POST)
    public
    @ResponseBody
    String editcomplaint(@RequestBody Complaint complaint, @PathVariable Integer complaint_id, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        boolean flag;
        flag = complaintService.editcomplaint(complaint, complaint_id);

        jsonObject.put("status", flag);

        return jsonObject.toString();

    }


    @RequestMapping(value = "/EditSpeciality/{speciality_id}", method = RequestMethod.POST)
    public
    @ResponseBody
    String editSpeciality(@RequestBody Speciality speciality, @PathVariable Integer speciality_id, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        boolean flag;
        flag = specialityService.editSpeciality(speciality, speciality_id);
        jsonObject.put("status", flag);

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

    @RequestMapping(value = "/EditContact/{branch_id}/{contact_no}", method = RequestMethod.GET)
    public
    @ResponseBody
    String EditContact(@PathVariable Integer branch_id, @PathVariable String contact_no) throws JSONException {
        JSONObject data = new JSONObject();
        List<Branch> validateNo;
        validateNo = clinicService.validateno(contact_no);

        if (validateNo.isEmpty()) {
            data.put("status", true);
        } else {
            Iterator<Branch> it = validateNo.iterator();
            while (it.hasNext()) {
                Branch validateNumber = it.next();
                if (branch_id == validateNumber.getBranch_id()) {
                    data.put("status", true);
                } else {
                    data.put("status", false);
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


    @RequestMapping(value = "/trackSessionBranch/{email:.+}", method = RequestMethod.GET)
    public
    @ResponseBody
    String trackSessionBranch(@PathVariable String email) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        List<Doctor> trackDetails;
        trackDetails = doctorService.trackSeason(email);

        Iterator<Doctor> itr = trackDetails.iterator();
        while (itr.hasNext()) {
            Doctor track = itr.next();
            jsonObject.put("clinic_id", track.getClinic_id());
            jsonObject.put("branch_id", track.getBranch_id());
            jsonObject.put("doctor_id", track.getDoctor_id());
            jsonObject.put("branch_name",track.getQualification());
            jsonObject.put("clinic_name",track.getCreated_by());
            jsonObject.put("status", true);
        }


        return jsonObject.toString();
    }

    @RequestMapping(value = "/trackSessionBranchDoctor/{email:.+}",method = RequestMethod.GET)
    public
    @ResponseBody
    String trackSessionBranchDoctor(@PathVariable String email)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        List<Doctor> trackDetails;
        trackDetails = doctorService.trackSeasonDoctor(email);
        Iterator<Doctor> itr = trackDetails.iterator();
        while (itr.hasNext()) {
            Doctor track = itr.next();
            jsonObject.put("clinic_id", track.getClinic_id());
            jsonObject.put("branch_id", track.getBranch_id());
            jsonObject.put("doctor_id", track.getDoctor_id());
            jsonObject.put("clinic_name",track.getQualification());

            jsonObject.put("status", true);
        }


        return jsonObject.toString();
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


    @RequestMapping(value = "/BloodGroup", method = RequestMethod.GET)
    public
    @ResponseBody
    String bloodgroup(HttpServletRequest request) throws JSONException {

        JSONArray jsonArray = new JSONArray();
        JSONObject data = new JSONObject();
        List<Blood> bloodDetails;
        bloodDetails = patientService.bloodtypeDetails();
        Iterator<Blood> it = bloodDetails.iterator();
        while (it.hasNext()) {
            Blood getDetails = it.next();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("blood_id", getDetails.getBlood_id());
            jsonObject.put("blood_type", getDetails.getBlood_type());
            jsonArray.put(jsonObject);

        }
        data.put("blood", jsonArray);

        return data.toString();

    }

    @RequestMapping(value = "/ViewMedicine", method = RequestMethod.GET)
    public
    @ResponseBody
    String viewMedicine() throws JSONException {
        JSONArray jsonArray = new JSONArray();
        JSONObject data = new JSONObject();
        List<Medicine> medicineList;
        medicineList = medicineService.getMedicine();
        Iterator<Medicine> it = medicineList.iterator();
        while (it.hasNext()) {
            Medicine getMedicine = it.next();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("medicine_id", getMedicine.getMedicine_id());
            jsonObject.put("medicine_name", getMedicine.getMedicine_name());
            jsonObject.put("mg", getMedicine.getMg());
            jsonObject.put("type", getMedicine.getType());
            jsonObject.put("vendor", getMedicine.getVendor());
            jsonArray.put(jsonObject);
        }

        data.put("medicines", jsonArray);
        return data.toString();
    }


    @RequestMapping(value = "/ValidatePatient/{contact_no}", method = RequestMethod.GET)
    public
    @ResponseBody
    String validatePatient(@PathVariable String contact_no, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        List<Patient> validateNo;
        validateNo = patientService.validatePatient(contact_no);
        if (validateNo.isEmpty()) {
            jsonObject.put("status", true);
        } else {
            jsonObject.put("status", false);
        }


        return jsonObject.toString();
    }

    @RequestMapping(value = "/Doctorname/{speciallity_id}/{branch_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String doctordetails(@PathVariable String speciallity_id, @PathVariable String branch_id, HttpServletRequest request) throws JSONException {
        JSONObject data = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<DoctorUser> specialities;
        specialities = doctorService.doctorspecailities(speciallity_id, branch_id);
        Iterator<DoctorUser> it = specialities.iterator();
        while (it.hasNext()) {
            DoctorUser profile = it.next();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("profile_id", profile.getProfile_id());
            jsonObject.put("profile_name", profile.getFirstname());
            jsonObject.put("doctor_id", profile.getDoctor_id());
            jsonArray.put(jsonObject);
        }
        data.put("profile", jsonArray);


        return data.toString();
    }

    @RequestMapping(value = "MedicineDetails/{medicine_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String medicineDetails(@PathVariable Integer medicine_id) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        Medicine medicineDetails = new Medicine();
        medicineDetails = medicineService.medicineDetails(medicine_id);
        jsonObject.put("medicine_id", medicineDetails.getMedicine_id());
        jsonObject.put("medicine_name", medicineDetails.getMedicine_name());
        jsonObject.put("mg", medicineDetails.getMg());
        jsonObject.put("type", medicineDetails.getType());
        jsonObject.put("vendor", medicineDetails.getVendor());

        return jsonObject.toString();
    }

    @RequestMapping(value = "/EditMedicine")
    public
    @ResponseBody
    String editMedicine(@RequestBody Medicine medicine) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        boolean flag;
        flag = medicineService.editMedicine(medicine);
        jsonObject.put("status", flag);
        return jsonObject.toString();
    }

    @RequestMapping(value = "patientHistory/{doctor_id}/{branch_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String patientHistory(@PathVariable Integer doctor_id, @PathVariable Integer branch_id) throws JSONException {

        JSONObject data = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<PatientInfo> patientInfos;
        patientInfos = patientInfoService.getPatientInfo(doctor_id, branch_id);
        Iterator<PatientInfo> it = patientInfos.iterator();
        while (it.hasNext()) {
            PatientInfo patientinfo = it.next();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("patient_pid", patientinfo.getPatient_pid());
            jsonObject.put("first_name", patientinfo.getFirst_name());
            jsonObject.put("last_name", patientinfo.getLast_name());
            jsonObject.put("date", patientinfo.getDate());
            jsonObject.put("referal_details", patientinfo.getRefereal_details());
            jsonArray.put(jsonObject);
        }

        data.put("patientinfo", jsonArray);

        return data.toString();
    }


    @RequestMapping(value = "/ViewPatientVisit/{branch_id}/{doctor_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String viewPatientVisit(@PathVariable String branch_id, @PathVariable String doctor_id, HttpServletRequest request) throws JSONException {
        JSONObject data = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<PatientVisit> PatientVisit;
        if (doctor_id.equalsIgnoreCase("ALL")) {

            PatientVisit = patientService.patientEntryAll(branch_id);

        } else {
            PatientVisit = patientService.patientEntry(doctor_id, branch_id);
        }

        Iterator<PatientVisit> it = PatientVisit.iterator();
        while (it.hasNext()) {
            PatientVisit visit = it.next();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("first_name", visit.getFirst_name());
            jsonObject.put("last_name", visit.getLast_name());
            jsonObject.put("patient_pid", visit.getPatient_pid());
            jsonObject.put("entry_time", visit.getTime());
            jsonObject.put("referal_details", visit.getReferal_details());
            jsonArray.put(jsonObject);

        }
        data.put("patient", jsonArray);
        return data.toString();
    }

    @RequestMapping(value = "ViewDoctorBranch/{branch_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String viewDoctor(@PathVariable String branch_id, HttpServletRequest request) throws JSONException {
        JSONObject data = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<DoctorUser> doctorUsers;
        doctorUsers = doctorService.getDoctor(branch_id);
        Iterator<DoctorUser> itr = doctorUsers.iterator();
        while (itr.hasNext()) {
            DoctorUser doctorvisit = itr.next();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("profile_id", doctorvisit.getProfile_id());
            jsonObject.put("profile_name", doctorvisit.getFirstname());
            jsonObject.put("doctor_id", doctorvisit.getDoctor_id());
            jsonArray.put(jsonObject);

        }
        data.put("user", jsonArray);
        return data.toString();
    }

    @RequestMapping(value = "PrescriptionType/{type}", method = RequestMethod.GET)
    public
    @ResponseBody
    String prescriptionType(@PathVariable Integer type, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<Medicine> medicinesTypes;
        medicinesTypes = medicineService.getMedicineType(type);
        Iterator<Medicine> it = medicinesTypes.iterator();
        while (it.hasNext()) {
            Medicine medicine = it.next();
            JSONObject data = new JSONObject();
            data.put("medicine_id", medicine.getMedicine_id());
            data.put("medicine_name", medicine.getMedicine_name());
            data.put("mg", medicine.getMg());
            jsonArray.put(data);
        }
        jsonObject.put("medicines", jsonArray);

        return jsonObject.toString();
    }


    @RequestMapping(value = "ShowPatient/{branch_id}/{doctor_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String showpatient(@PathVariable String branch_id, @PathVariable String doctor_id, HttpServletRequest request) throws JSONException {
        JSONObject data = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<PatientVisit> patientvisits;
        patientvisits = patientService.patientEntry(doctor_id, branch_id);

        Iterator<PatientVisit> it = patientvisits.iterator();
        while (it.hasNext()) {
            PatientVisit visit = it.next();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("visit_id", visit.getVisit_id());
            jsonObject.put("first_name", visit.getFirst_name());
            jsonObject.put("last_name", visit.getLast_name());
            jsonObject.put("patient_pid", visit.getPatient_pid());
            jsonObject.put("entry_time", visit.getTime());
            jsonObject.put("referal_details", visit.getReferal_details());
            jsonObject.put("type", visit.getHeight());
            jsonArray.put(jsonObject);

        }
        data.put("patient", jsonArray);
        return data.toString();
    }


    @RequestMapping(value = "/GetServices/{branch_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String getServices(HttpServletRequest request, @PathVariable Integer branch_id) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<Service> services;
        services = servicesService.getServices(branch_id);
        Iterator<Service> it = services.iterator();
        while (it.hasNext()) {
            Service ser = it.next();
            JSONObject data = new JSONObject();
            data.put("service_id", ser.getService_id());
            data.put("service_name", ser.getService_name());
            data.put("description", ser.getDescription());
            data.put("charges", ser.getCharges());
            jsonArray.put(data);
        }
        jsonObject.put("services", jsonArray);
        return jsonObject.toString();
    }

    @RequestMapping(value = "/ServiceDetails/{service_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String serviceDetails(@PathVariable Integer service_id, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        Service service;
        service = servicesService.serviceDetails(service_id);
        jsonObject.put("service_name", service.getService_name());
        jsonObject.put("service_id", service.getService_id());
        jsonObject.put("description", service.getDescription());
        jsonObject.put("charges", service.getCharges());
        jsonObject.put("status", true);

        return jsonObject.toString();
    }

    @RequestMapping(value = "/EditService/{branch_id}", method = RequestMethod.POST)
    public
    @ResponseBody
    String editService(@RequestBody Service service, HttpServletRequest request, @PathVariable Integer branch_id) throws JSONException {

        JSONObject jsonObject = new JSONObject();
        boolean flag;
        flag = servicesService.editService(service, branch_id);
        jsonObject.put("status", flag);
        return jsonObject.toString();

    }

    @RequestMapping(value = "/GetPrescription/{patient_info_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String getPrescription(@PathVariable Integer patient_info_id, HttpServletRequest request) throws JSONException {

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<Prescription> prescriptions;
        prescriptions = prescriptionService.getPrescription(patient_info_id);
        Iterator<Prescription> it = prescriptions.iterator();
        while (it.hasNext()) {
            Prescription pres = it.next();
            JSONObject data = new JSONObject();
            data.put("prescription_id", pres.getPrescription_id());
            data.put("medicine_id", pres.getMedicine_id());
            data.put("medicine_name", pres.getMedicine_name());
            data.put("mg", pres.getMg());
            data.put("patient_info_id", pres.getPatient_info_id());
            data.put("frequency", pres.getFrequency());
            data.put("mrg_qty", pres.getMrg_qty());
            data.put("aft_qty", pres.getAft_qty());
            data.put("ngt_qty", pres.getNig_qty());
            data.put("days", pres.getDays());
            data.put("remarks", pres.getRemarks());
            data.put("day1", pres.getDays1());
            data.put("day2", pres.getDays2());
            data.put("day3", pres.getDays3());
            data.put("day4", pres.getDays4());
            data.put("day5", pres.getDays5());
            data.put("day6", pres.getDays6());
            data.put("day7", pres.getDays7());
            jsonArray.put(data);
        }

        jsonObject.put("prescription", jsonArray);
        return jsonObject.toString();
    }

    @RequestMapping(value = "/RemovePrescription", method = RequestMethod.POST)
    public
    @ResponseBody
    String removePrescription(@RequestBody Prescripe Prescription, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();

        boolean flag;
        flag = prescriptionService.removeprescription(Prescription);
        jsonObject.put("status", flag);

        return jsonObject.toString();
    }

    @RequestMapping(value = "/GetPrescriptionbyId/{prescription_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String getprescriptionById(@PathVariable Integer prescription_id, HttpServletRequest request) throws JSONException {

        JSONObject jsonObject = new JSONObject();
        Prescription prescription;
        prescription = prescriptionService.getPrescriptionById(prescription_id);
        jsonObject.put("medicine_name", prescription.getMedicine_name());
        jsonObject.put("medicine_id", prescription.getMedicine_id());
        jsonObject.put("prescription_id", prescription.getPrescription_id());
        jsonObject.put("mrg_qty", prescription.getMrg_qty());
        jsonObject.put("aft_qty", prescription.getAft_qty());
        jsonObject.put("ngt_qty", prescription.getNig_qty());
        jsonObject.put("days", prescription.getDays());
        jsonObject.put("frequency", prescription.getFrequency());
        jsonObject.put("remarks", prescription.getRemarks());
        jsonObject.put("type", prescription.getType());
        jsonObject.put("day1", prescription.getDays1());
        jsonObject.put("day2", prescription.getDays2());
        jsonObject.put("day3", prescription.getDays3());
        jsonObject.put("day4", prescription.getDays4());
        jsonObject.put("day5", prescription.getDays5());
        jsonObject.put("day6", prescription.getDays6());
        jsonObject.put("day7", prescription.getDays7());
        return jsonObject.toString();
    }


    @RequestMapping(value = "/DoctorDetailCharges/{doctor_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String doctorDetailCharges(@PathVariable Integer doctor_id, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        DoctorUser doctorUser;
        doctorUser = doctorService.getDoctorCharges(doctor_id);
        jsonObject.put("charges", doctorUser.getCharge());

        return jsonObject.toString();
    }


    @RequestMapping(value = "/AddInvestigation", method = RequestMethod.POST)
    public
    @ResponseBody
    String addInvestigation(@RequestBody Investigation investigation, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        boolean flag;
        flag = investigationService.addInvestigation(investigation);
        jsonObject.put("status", flag);
        return jsonObject.toString();
    }

    @RequestMapping(value = "/GetDoctorProfile/{doctor_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String getDoctorProfile(@PathVariable Integer doctor_id, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        DoctorUser profile;
        profile = doctorService.getDoctorprofile(doctor_id);
        jsonObject.put("name", profile.getFirstname());
        jsonObject.put("address1", profile.getAddress1());
        jsonObject.put("email", profile.getEmail_id());
        jsonObject.put("qualification", profile.getQualification());


        return jsonObject.toString();
    }


    @RequestMapping(value = "/GetInvestigation/{visit_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String getInvestigation(@PathVariable Integer visit_id, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        Investigation investigation;
        List<InvestServices> investServices;
        investigation = investigationService.getCharges(visit_id);
        jsonObject.put("total_amount", investigation.getTotal_amount());
        jsonObject.put("status", true);
        investServices = investigation.getInvestServices();
        Iterator<InvestServices> it = investServices.iterator();
        while (it.hasNext()) {
            InvestServices investServices1 = it.next();
            JSONObject data = new JSONObject();
            data.put("charges", investServices1.getCharges());
            data.put("discount", investServices1.getDiscount());
            data.put("service_name", investServices1.getService_name());
            jsonArray.put(data);
        }

        jsonObject.put("services", jsonArray);


        return jsonObject.toString();
    }

    @RequestMapping(value = "/GetEntryNew/{patient_pid}/{type}/{doctor_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String getEntryNew(@PathVariable String patient_pid, @PathVariable Integer type, @PathVariable Integer doctor_id, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        List<PatientVisit> patientVisit;
        boolean flag;
        patientVisit = patientService.getEntryNew(patient_pid, type, doctor_id);
        if (patientVisit.isEmpty()) {
            jsonObject.put("status", true);
        } else {
            jsonObject.put("status", false);
        }


        return jsonObject.toString();
    }

    @RequestMapping(value = "/GetPatientInfo/{patient_pid}/{doctor_id}/{branch_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String getpatientInfo(@PathVariable String patient_pid, @PathVariable Integer doctor_id, @PathVariable Integer branch_id, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        PatientInfo patientInfo;
        List<Complaint> complaints;
        patientInfo = patientInfoService.getPatientFollow(patient_pid, doctor_id, branch_id);
        jsonObject.put("procedures", patientInfo.getProcedures());
        jsonObject.put("diagonics", patientInfo.getDiagnosis());
        jsonObject.put("observation", patientInfo.getObservation());
        jsonObject.put("investigation", patientInfo.getInvestigation());
        jsonObject.put("patient_info_id", patientInfo.getPatient_info_id());
        complaints = patientInfo.getComplaint();
        Iterator<Complaint> itr = complaints.iterator();
        while (itr.hasNext()) {
            Complaint complaint = itr.next();
            JSONObject data = new JSONObject();
            data.put("complaint_name", complaint.getComplaint_name());
            data.put("complaint_description", complaint.getComplaint_description());
            data.put("complaint_id", complaint.getComplaint_id());
            jsonArray.put(data);
        }
        jsonObject.put("complaints", jsonArray);

        return jsonObject.toString();
    }

    @RequestMapping(value = "/EditPatientInfo", method = RequestMethod.POST)
    public
    @ResponseBody
    String editPatientInfo(@RequestBody PatientInfo patientInfo, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        boolean flag;

        flag = patientInfoService.editPatientInfo(patientInfo);
        jsonObject.put("status", flag);
        return jsonObject.toString();
    }


    @RequestMapping(value = "/GetFollowUp/{patient_pid}/{doctor_id}/{type}", method = RequestMethod.GET)
    public
    @ResponseBody
    String getFollowUp(@PathVariable String patient_pid, @PathVariable Integer doctor_id, @PathVariable Integer type, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        boolean flag;
        List<PatientVisit> patientVisits;
        patientVisits = patientService.getEntryFollowup(patient_pid, doctor_id, type);
        if (patientVisits.isEmpty()) {
            jsonObject.put("status", true);
        } else {
            jsonObject.put("status", false);
        }


        return jsonObject.toString();
    }

    @RequestMapping(value = "/GetPatientInfoReport/{patient_pid}/{from_date}/{to_date}/{doctor_id}/{branch_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String getPatientReport(@PathVariable String patient_pid, @PathVariable String from_date, @PathVariable String to_date, @PathVariable Integer doctor_id, @PathVariable Integer branch_id, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<PatientReport> patientInfos;
        patientInfos = patientInfoService.getPatientReport(patient_pid, from_date, to_date, doctor_id, branch_id);
        Iterator<PatientReport> it = patientInfos.iterator();
        while (it.hasNext()) {
            PatientReport patientReport = it.next();
            JSONObject data = new JSONObject();
            data.put("first_name", patientReport.getFirst_name());
            data.put("last_name", patientReport.getLast_name());
            data.put("pateint_info_id", patientReport.getPatient_info_id());
            data.put("referal_details", patientReport.getReferal_details());
            data.put("created_at", patientReport.getDate());
            data.put("patient_pid", patientReport.getPatient_pid());
            jsonArray.put(data);
        }
        jsonObject.put("report", jsonArray);
        return jsonObject.toString();
    }

    @RequestMapping(value = "/GetPatientReportByMonths/{patient_pid}/{date}/{doctor_id}/{branch_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String getpatientReportByMonths(@PathVariable String patient_pid, @PathVariable String date, @PathVariable Integer doctor_id, @PathVariable Integer branch_id, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<PatientReport> patientInfos;
        patientInfos = patientInfoService.getPatientReportByMonths(patient_pid, date, doctor_id, branch_id);
        Iterator<PatientReport> it = patientInfos.iterator();
        while (it.hasNext()) {
            PatientReport patientReport = it.next();
            JSONObject data = new JSONObject();
            data.put("first_name", patientReport.getFirst_name());
            data.put("last_name", patientReport.getLast_name());
            data.put("pateint_info_id", patientReport.getPatient_info_id());
            data.put("referal_details", patientReport.getReferal_details());
            data.put("created_at", patientReport.getDate());
            data.put("patient_pid", patientReport.getPatient_pid());
            jsonArray.put(data);
        }
        jsonObject.put("report", jsonArray);


        return jsonObject.toString();
    }

    @RequestMapping(value = "/GetInfoDetails/{patient_info_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String getInfoDetails(@PathVariable Integer patient_info_id, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        PatientReport patientReport;
        List<Complaint> complaints;
        patientReport = patientInfoService.getInfoDetails(patient_info_id);

        jsonObject.put("first_name", patientReport.getFirst_name());
        jsonObject.put("last_name", patientReport.getLast_name());
        jsonObject.put("diagonics", patientReport.getDiagonics());
        jsonObject.put("procedures", patientReport.getProcedures());
        jsonObject.put("patient_pid", patientReport.getPatient_pid());
        jsonObject.put("observation", patientReport.getObservation());
        jsonObject.put("investigation", patientReport.getInvestigation());
        jsonObject.put("type", patientReport.getType());
        jsonObject.put("bp", patientReport.getBp());
        jsonObject.put("created_at", patientReport.getDate());
        complaints = patientReport.getComplaints();
        Iterator<Complaint> itr = complaints.iterator();
        while (itr.hasNext()) {
            Complaint complaint = itr.next();
            JSONObject data = new JSONObject();
            data.put("complaint_id", complaint.getComplaint_id());
            data.put("complaint_name", complaint.getComplaint_name());
            data.put("complaint_description", complaint.getComplaint_description());
            jsonArray.put(data);
        }
        jsonObject.put("complaints", jsonArray);
        return jsonObject.toString();
    }


    @RequestMapping(value = "/AddLaboratory", method = RequestMethod.POST)
    public
    @ResponseBody
    String addLaboratory(@RequestBody Laboratory laboratory) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        boolean flag;
        flag = laboratoryService.addLaboratory(laboratory);
        jsonObject.put("status", flag);

        return jsonObject.toString();
    }

    @RequestMapping(value = "/GetLaboratory", method = RequestMethod.GET)
    public
    @ResponseBody
    String getLaboratory(HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<Laboratory> laboratories;
        laboratories = laboratoryService.getLaboratory();
        Iterator<Laboratory> it = laboratories.iterator();
        while (it.hasNext()) {
            Laboratory laboratory = it.next();
            JSONObject data = new JSONObject();
            data.put("test_id", laboratory.getTest_id());
            data.put("test_type", laboratory.getTest_type());
            data.put("test_name", laboratory.getTest_name());
            data.put("description", laboratory.getDescription());
            jsonArray.put(data);
        }
        jsonObject.put("laboratory", jsonArray);
        return jsonObject.toString();
    }

    @RequestMapping(value = "/GetLaboratoryId/{test_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String getLaboratoryId(@PathVariable Integer test_id, HttpServletRequest request) throws JSONException {

        JSONObject jsonObject = new JSONObject();
        Laboratory laboratory = new Laboratory();
        laboratory = laboratoryService.getLaboratoryId(test_id);
        jsonObject.put("test_id", laboratory.getTest_id());
        jsonObject.put("test_type", laboratory.getTest_type());
        jsonObject.put("test_name", laboratory.getTest_name());
        jsonObject.put("description", laboratory.getDescription());
        return jsonObject.toString();
    }

    @RequestMapping(value = "/EditLaboratoryId", method = RequestMethod.POST)
    public
    @ResponseBody
    String editLaboratoryId(@RequestBody Laboratory laboratory, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        boolean flag;
        flag = laboratoryService.editLaboratory(laboratory);
        jsonObject.put("status", flag);
        return jsonObject.toString();

    }

    @RequestMapping(value = "/LabType", method = RequestMethod.GET)
    public
    @ResponseBody
    String getLabtype(HttpServletRequest request) throws JSONException {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        List<Laboratory> laboratories;
        laboratories = laboratoryService.TypeLab();
        Iterator<Laboratory> it = laboratories.iterator();
        while (it.hasNext()) {
            Laboratory laboratory = it.next();
            JSONObject data = new JSONObject();
            data.put("test_type", laboratory.getTest_type());
            jsonArray.put(data);
        }
        jsonObject.put("laboratory", jsonArray);


        return jsonObject.toString();

    }

    @RequestMapping(value = "/LaboratoryType/{test_type}", method = RequestMethod.GET)
    public
    @ResponseBody
    String laboratoryType(@PathVariable String test_type) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<Laboratory> laboratoryList;
        laboratoryList = laboratoryService.getLaboratoryType(test_type);
        Iterator<Laboratory> it = laboratoryList.iterator();
        while (it.hasNext()) {
            Laboratory laboratory = it.next();
            JSONObject data = new JSONObject();
            data.put("test_id", laboratory.getTest_id());
            data.put("test_name", laboratory.getTest_name());
            jsonArray.put(data);
        }
        jsonObject.put("laboratory", jsonArray);


        return jsonObject.toString();


    }

    @RequestMapping(value = "/AddLabReferences", method = RequestMethod.POST)
    public
    @ResponseBody
    String addLabreferences(@RequestBody LabInvestigation labInvestigation) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        boolean flag;
        flag = labInvestigationService.addLabInvestigation(labInvestigation);
        jsonObject.put("status", flag);

        return jsonObject.toString();

    }

    @RequestMapping(value = "/GetLabInvest/{patient_info_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String getLabInvest(@PathVariable Integer patient_info_id, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<LabInvestigation> labInvestigationList;
        labInvestigationList = labInvestigationService.getInvestigation(patient_info_id);
        Iterator<LabInvestigation> it = labInvestigationList.iterator();
        while (it.hasNext()) {
            LabInvestigation labInvestigation = it.next();
            JSONObject data = new JSONObject();
            data.put("test_type", labInvestigation.getTest_type());
            data.put("test_name", labInvestigation.getTest_name());
            data.put("remarks", labInvestigation.getRemarks());
            data.put("investigation_id", labInvestigation.getLabinvestigation_id());
            jsonArray.put(data);
        }
        jsonObject.put("labinvest", jsonArray);

        return jsonObject.toString();
    }

    @RequestMapping(value = "/RemoveLabInvest/{investigation_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String removeLabInvest(@PathVariable Integer investigation_id, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        boolean flag;

        flag = labInvestigationService.removeLabInvestigation(investigation_id);
        jsonObject.put("status", flag);
        return jsonObject.toString();
    }


    @RequestMapping(value = "/GetLabInvestigationId/{investigation_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String getLabInvestigationId(@PathVariable Integer investigation_id, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        LabInvestigation labInvestigation = new LabInvestigation();
        labInvestigation = labInvestigationService.getLabInvestigation(investigation_id);
        jsonObject.put("labinvestigation_id", labInvestigation.getLabinvestigation_id());
        jsonObject.put("test_type", labInvestigation.getTest_type());
        jsonObject.put("test_name", labInvestigation.getTest_name());
        jsonObject.put("remarks", labInvestigation.getRemarks());


        return jsonObject.toString();
    }

    @RequestMapping(value = "/GetLabtype/{test_name}", method = RequestMethod.GET)
    public
    @ResponseBody
    String getLabTypes(@PathVariable String test_name, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        Laboratory laboratory = new Laboratory();
        laboratory = laboratoryService.getLabType(test_name);
        jsonObject.put("test_type", laboratory.getTest_type());
        jsonObject.put("test_id", laboratory.getTest_id());
        jsonObject.put("desc", laboratory.getDescription());

        return jsonObject.toString();
    }

    @RequestMapping(value = "/EditLabInvestigation", method = RequestMethod.POST)
    public
    @ResponseBody
    String editLabInvestigation(@RequestBody LabInvestigation labInvestigation) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        Boolean flag;
        flag = labInvestigationService.editlabInvestigation(labInvestigation);
        jsonObject.put("status", flag);

        return jsonObject.toString();
    }

    @RequestMapping(value = "/GetFollowUpWeek/{patient_pid}/{type}/{doctor_id}/{date}", method = RequestMethod.GET)
    public
    @ResponseBody
    String getFollowupWeek(@PathVariable String patient_pid, @PathVariable Integer type, @PathVariable Integer doctor_id, @PathVariable String date) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        List<PatientVisit> patientVisits;
        patientVisits = patientService.getFollowUp(patient_pid, type, doctor_id, date);
        if (patientVisits.isEmpty()) {
            jsonObject.put("status", false);
        } else {
            jsonObject.put("status", true);
        }

        return jsonObject.toString();
    }

    @RequestMapping(value = "/GetAllEntry/{patient_pid}/{doctor_id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String getAllEntry(@PathVariable String patient_pid, @PathVariable Integer doctor_id) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        List<PatientVisit> patientVisits;
        patientVisits = patientService.getAllEntry(patient_pid, doctor_id);
        if (patientVisits.isEmpty()) {
            jsonObject.put("status", false);
        } else {
            jsonObject.put("status", true);
        }


        return jsonObject.toString();
    }

    @RequestMapping(value = "/fPassword/{email_id:.+}", method = RequestMethod.GET)
    public
    @ResponseBody
    String fPassword(@PathVariable String email_id) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        boolean flag;
        List<User> users;
        users = userService.validateEmail(email_id);
        if (users.isEmpty()) {
            jsonObject.put("status", false);
        } else {
            flag = userService.getPassword(email_id);
            jsonObject.put("status", flag);
        }
        return jsonObject.toString();
    }

    @RequestMapping(value = "/cpassword", method = RequestMethod.GET)
    public String cPassword(@RequestParam String token) throws JSONException {
        List<User> user;
        user = userService.validateToken(token);
        if (user.isEmpty()) {
            return "resetPassword";
        } else {
            return "login";
        }


    }

    @RequestMapping(value = "/ResetPassword/{token}/{password}", method = RequestMethod.POST)
    public
    @ResponseBody
    String resetPassword(@PathVariable String token, @PathVariable String password, HttpServletRequest request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        Boolean flag;
        flag = userService.resetPassword(token, encryptPassword(password));


        jsonObject.put("status", flag);

        return jsonObject.toString();
    }

    @RequestMapping(value = "/AddSchedule", method = RequestMethod.POST)
    public
    @ResponseBody
    String addSchedule(@RequestBody Schedule schedule) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        Boolean flag;
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        Integer str[] = new Integer[7];
        str[0] = schedule.getDay_flag().getDay1();
        str[1] = schedule.getDay_flag().getDay2();
        str[2] = schedule.getDay_flag().getDay3();
        str[3] = schedule.getDay_flag().getDay4();
        str[4] = schedule.getDay_flag().getDay5();
        str[5] = schedule.getDay_flag().getDay6();
        str[6] = schedule.getDay_flag().getDay7();
        for (Integer word : str) {
            if (word != null && word > 0) {
                if (first) {
                    first = false;
                } else {
                    sb.append(',');
                }
                sb.append(word);
            }
        }
        if (schedule.getEnd_type() == 0) {
            schedule.setEnd_date("0");
        } else {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date date = new Date(schedule.getStart_date());
            cal.setTime(date);
            cal.add(Calendar.DATE, schedule.getNo_of_occurenes());
            schedule.setEnd_date(dateFormat.format(cal.getTime()));
        }
        flag = scheduleService.addSchedule(schedule, sb);
        jsonObject.put("status", flag);
        return jsonObject.toString();
    }

    @RequestMapping(value = "/ValidateSchedule", method = RequestMethod.POST)
    public
    @ResponseBody
    String validateSchedule(@RequestBody Schedule schedule) throws JSONException, ParseException {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<Schedule> scheduleList;
        List<String> getDateCompare = new ArrayList<String>();
        List<String> getOld = new LinkedList<String>();
        scheduleList = scheduleService.getScheduleDoctor(schedule.getDoctor_id(), schedule.getStart_date());

        DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");

        String schedulestart_time = schedule.getStart_time();
        String scheduleend_time = schedule.getEnd_time();

        if (scheduleList.isEmpty()) {
            jsonObject.put("status", true);
        } else {
            Iterator<Schedule> scheduleIterator = scheduleList.iterator();
            while (scheduleIterator.hasNext()) {
                List<String> getOldDateCompare = new ArrayList<String>();
                Schedule sc = scheduleIterator.next();

                String scstart_time = sc.getStart_time();
                String scend_time = sc.getEnd_time();

                if (schedule.getEnd_type() == 1) {
                    Date date = new Date();
                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                    calendar.setTime(date);
                    calendar.add(Calendar.DATE, schedule.getNo_of_occurenes());
                    schedule.setEnd_date(dateFormat.format(calendar.getTime()));
                    getDateCompare = getCurrentSchedule(schedule.getStart_date(), schedule.getEnd_date(), schedule.getDay_flag());
                } else {
                    Date date = new Date();
                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                    calendar.setTime(date);
                    calendar.add(Calendar.DATE, 30);
                    schedule.setEnd_date(dateFormat.format(calendar.getTime()));
                    String ed_date = dateFormat.format(calendar.getTime());
                    getDateCompare = getCurrentSchedule(schedule.getStart_date(), ed_date, schedule.getDay_flag());
                }

                if (sc.getEnd_type() == 1) {
                    getOldDateCompare = getOldSchedule(schedule.getStart_date(), sc.getEnd_date(), sc.getDay_flags());
                } else {
                    Date date1 = new Date();
                    Calendar calendar1 = Calendar.getInstance();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                    calendar1.setTime(date1);
                    calendar1.add(Calendar.DATE, 30);
                    String end_dt = dateFormat.format(calendar1.getTime());

                    getOldDateCompare = getOldSchedule(schedule.getStart_date(), end_dt, sc.getDay_flags());

                }
                for (String date1 : getDateCompare) {
                    for (String date2 : getOldDateCompare) {
                        if (date1.equalsIgnoreCase(date2)) {

                            String scstart_date = date2 + " " + scstart_time;
                            String scend_date = date2 + "  " + scend_time;
                            String schedulestart_date = date1 + "  " + schedulestart_time;
                            String scheduleend_date = date1 + " " + scheduleend_time;
                            Date d1 = sdf.parse(scstart_date);
                            Date d2 = sdf.parse(scend_date);
                            Date d3 = sdf.parse(schedulestart_date);
                            Date d4 = sdf.parse(scheduleend_date);

                            if ((d3.before(d2) && (d3.after(d1))) || (d3.before(d1) && (d4.after(d1))) || (d3.equals(d1) && (d4.before(d2))) || (d3.equals(d1))) {
                               /* JSONObject data=new JSONObject();
                                data.put("start_date",sc.getStart_date());
                                data.put("end_date",sc.getEnd_date());
                                data.put("start_time",sc.getStart_time());
                                data.put("end_time",sc.getEnd_time());
                                jsonArray.put(data);
                                jsonObject.put("conflict",jsonArray);*/
                                jsonObject.put("status", true);
                                return jsonObject.toString();

                            } else {

                                jsonObject.put("status", false);
                            }
                        } else {
                            jsonObject.put("status", false);
                        }
                    }
                }


            }


        }
        return jsonObject.toString();
    }

    public static List<String> getCurrentSchedule(String startDate, String endDate, Schedule_day schedule_day) {
        List<String> datesInRange = new ArrayList<String>();
        List<String> dateRange = new ArrayList<String>();
        Calendar calendar = new GregorianCalendar();
        Calendar endCalendar = new GregorianCalendar();
        Calendar weekCalender = new GregorianCalendar();
        Date strtDate = new Date(startDate);
        Date edDate = new Date(endDate);
        Integer str[] = new Integer[7];
        str[0] = schedule_day.getDay1();
        str[1] = schedule_day.getDay2();
        str[2] = schedule_day.getDay3();
        str[3] = schedule_day.getDay4();
        str[4] = schedule_day.getDay5();
        str[5] = schedule_day.getDay6();
        str[6] = schedule_day.getDay7();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        calendar.setTime(strtDate);
        endCalendar.setTime(edDate);
        while (calendar.before(endCalendar)) {
            Date result = calendar.getTime();
            datesInRange.add(dateFormat.format(result));
            calendar.add(Calendar.DATE, 1);
        }
        for (String dats : datesInRange) {
            Date week = new Date(dats);
            weekCalender.setTime(week);
            for (Integer wk : str) {
                if (wk != null && weekCalender.get(Calendar.DAY_OF_WEEK) == wk) {
                    Date wks = weekCalender.getTime();
                    dateRange.add(dateFormat.format(wks));
                }
            }
        }
        return dateRange;
    }

    public static List<String> getOldSchedule(String startDate, String endDate, String day_flags) {

        List<String> datesInRange = new ArrayList<String>();
        List<String> dateRange = new ArrayList<String>();
        Calendar calendar = new GregorianCalendar();
        Calendar endCalendar = new GregorianCalendar();
        Calendar weekCalender = new GregorianCalendar();
        Date strtDate = new Date(startDate);
        Date edDate = new Date(endDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        calendar.setTime(strtDate);
        endCalendar.setTime(edDate);
        String arr[] = day_flags.split(",");
        Integer str[] = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            str[i] = Integer.parseInt(arr[i]);
        }
        while (calendar.before(endCalendar)) {
            Date result = calendar.getTime();
            datesInRange.add(dateFormat.format(result));
            calendar.add(Calendar.DATE, 1);
        }
        for (String dates : datesInRange) {
            Date week = new Date(dates);
            weekCalender.setTime(week);
            for (Integer wk : str) {
                if (wk != null && weekCalender.get(Calendar.DAY_OF_WEEK) == wk) {
                    Date wks = weekCalender.getTime();
                    dateRange.add(dateFormat.format(wks));
                }
            }
        }

        return dateRange;
    }

    @RequestMapping(value = "/patientDetailsById/{patient_pid}", method = RequestMethod.GET)
    public
    @ResponseBody
    String patientDetailsById(@PathVariable String patient_pid) throws Exception {
        JSONObject jsonObject = new JSONObject();
        JSONObject data = new JSONObject();
        Patient patient = patientService.patientdetailsById(patient_pid);
        if(patient==null){
            NewAppointment appointment=newAppointmentService.patientdetailsById(patient_pid);
            jsonObject.put("first_name",appointment.getFirst_name());
            jsonObject.put("last_name",appointment.getLast_name());
            jsonObject.put("address1",appointment.getAddress1());
            jsonObject.put("address2",appointment.getAddress2());
            jsonObject.put("contact_no",appointment.getMobile_no());
            jsonObject.put("patient_pid",appointment.getNew_appointment_pid());
            jsonObject.put("status",true);

        }else{
            jsonObject.put("first_name", patient.getFullName());
            jsonObject.put("last_name", patient.getLastName());
            jsonObject.put("address1", patient.getAddress1());
            jsonObject.put("address2", patient.getAddress2());
            jsonObject.put("dob", patient.getDob());
            jsonObject.put("city", patient.getCity());
            jsonObject.put("state", patient.getState());
            jsonObject.put("country", patient.getCountry());
            jsonObject.put("pincode", patient.getPincode());
            jsonObject.put("contact_no", patient.getContact_no());
            jsonObject.put("mobile_no", patient.getResidental_no());
            jsonObject.put("gender", patient.getGender());
            jsonObject.put("blood_group", patient.getBloodGroup());
            jsonObject.put("mstatus", patient.getmStatus());
            jsonObject.put("email", patient.getEmail());
            jsonObject.put("patient_pid", patient.getPatient_pId());
            jsonObject.put("patient_id", patient.getPatientId());
            jsonObject.put("status",true);
        }



        return jsonObject.toString();
    }

    @RequestMapping(value = "/GetDoctorSchedule/{doctor_id}/{branch_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String getDoctorSchedule(@PathVariable Integer doctor_id,@PathVariable Integer branch_id)throws Exception{
        JSONObject jsonObject=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        List<Schedule> scheduleList=null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String st_date=dateFormat.format(new Date());
        Calendar calendar = new GregorianCalendar();
        Date start_date=new Date(st_date);
        calendar.add(Calendar.MONTH,2);
        String end_dt = dateFormat.format(calendar.getTime());
        List<String> dates=null;
        HashSet<String> dates1=new HashSet<String>();
        HashSet<String> validateDates=null;
        scheduleList=scheduleService.getSchedule(doctor_id,st_date,branch_id);
        if(scheduleList.isEmpty()){
           /* dates1=getOldSchedule(st_date,end_dt);*/
            jsonObject.put("flags","");
        }else{
            Iterator<Schedule> scheduleIterator=scheduleList.iterator();
            while (scheduleIterator.hasNext()){
                JSONObject data=new JSONObject();
                Schedule sc=scheduleIterator.next();
                if(sc.getEnd_type()==1){
                    dates=getOldSchedule(st_date,sc.getEnd_date(),sc.getDay_flags());
                    jsonObject.put("flags",sc.getDay_flags());
                    validateDates=getOldSchedule(st_date,sc.getEnd_date());
                }else{
                    dates=getOldSchedule(st_date,end_dt,sc.getDay_flags());
                    validateDates=getOldSchedule(st_date,end_dt);
                    jsonObject.put("flags",sc.getDay_flags());
                }
                validateDates.removeAll(dates);
                dates1.addAll(dates);
            }
        }
        Iterator<String> itr=dates1.iterator();
        while (itr.hasNext()){
            String disable_dates=itr.next();
            jsonArray.put(disable_dates);
        }
        jsonObject.put("disable_dates",jsonArray);
        jsonObject.put("status",true);
        return jsonObject.toString();
    }
    public static HashSet<String> getOldSchedule(String startDate, String endDate) {
        HashSet<String> datesInRange = new HashSet<String>();
        Calendar calendar = new GregorianCalendar();
        Calendar endCalendar = new GregorianCalendar();
        Date strtDate = new Date(startDate);
        Date edDate = new Date(endDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        calendar.setTime(strtDate);
        endCalendar.setTime(edDate);
        while (calendar.before(endCalendar)) {
            Date result = calendar.getTime();
            datesInRange.add(dateFormat.format(result));
            calendar.add(Calendar.DATE, 1);
        }
        return datesInRange;
    }
    @RequestMapping(value = "GetScheduleTime/{date}/{doctor_id}/{branch_id}",method = RequestMethod.GET)
    public
    @ResponseBody
    String getScheduleTime(@PathVariable String date,@PathVariable Integer doctor_id,@PathVariable Integer branch_id)throws Exception{
        JSONObject jsonObject=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        JSONArray jsonArray1=new JSONArray();
        List<Schedule> scheduleList;
        date=date.replace("-","/");
        String date1=null;
        String date2=null;
        Integer interval=null;
        DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
        DateFormat sdf1 = new SimpleDateFormat(" hh:mm aa");
        Set<String> time=new HashSet<String>();
        List<Appointment> appointments;
        scheduleList=scheduleService.getScheduleTime(doctor_id,branch_id);
        Iterator<Schedule> scheduleIterator=scheduleList.iterator();
        List<String> dates=new ArrayList<String>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String st_date=dateFormat.format(new Date());
        Calendar calendar= new GregorianCalendar();
        calendar.add(Calendar.DATE,32);
        String end_dt = dateFormat.format(calendar.getTime());
        while (scheduleIterator.hasNext()){
            JSONObject data=new JSONObject();
            Schedule sc=scheduleIterator.next();
            if(sc.getEnd_type()==1){
                dates=getOldSchedule(st_date,sc.getEnd_date(),sc.getDay_flags());
            }else{
                dates=getOldSchedule(st_date,end_dt,sc.getDay_flags());
            }
            date1=date+" "+sc.getStart_time();
            date2=date+" "+sc.getEnd_time();
            if(sc.getTime()==0){
                interval=15;
            }else if(sc.getTime()==1){
                interval=30;
            }else if(sc.getTime()==2){
                interval=60;
            }
            Date str_date=new Date(date1);
            Date end_date=new Date(date2);
            Calendar calendar1=Calendar.getInstance();
            Calendar bcalender1=Calendar.getInstance();
            calendar1.setTime(str_date);
            bcalender1.setTime(end_date);
            while (!calendar1.after(bcalender1)){
                Date result=calendar1.getTime();
                time.add(sdf1.format(result));
                calendar1.add(Calendar.MINUTE,interval);}
        }
        appointments=appointmentService.appoinmentDetails(doctor_id,branch_id,date);
        Iterator<Appointment> it=appointments.iterator();
        List<String> inter=new ArrayList<String>();
        while (it.hasNext()){
            Appointment appointment=it.next();
            String dt_sc=appointment.getDov()+" "+appointment.getTime();
            Date date3=new Date(dt_sc);
            inter.add(sdf1.format(date3));
        }
        time.removeAll(inter);
        Iterator<String> itr=time.iterator();
        Iterator<String> itm=inter.iterator();
        while (itm.hasNext()){
            JSONObject data1=new JSONObject();
            String sh_time=itm.next();
            data1.put("interval",sh_time);
            data1.put("booked",0);
            jsonArray.put(data1);
        }
        while (itr.hasNext()){
            JSONObject data=new JSONObject();
            String sct_time=itr.next();
            data.put("interval",sct_time);
            data.put("booked",1);
            jsonArray.put(data);}

            jsonObject.put("schedule",jsonArray);
            jsonObject.put("date",date);
            jsonObject.put("status",true);
        return  jsonObject.toString();
    }
    @RequestMapping(value = "GetAppoinment/{doctor_id}/{branch_id}/{date}",method = RequestMethod.GET)
    public
    @ResponseBody
    String getAppoinment(@PathVariable Integer doctor_id,@PathVariable Integer branch_id,@PathVariable String date)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        List<Appointment> appointments;
        date=date.replace("-","/");
        appointments=appointmentService.appoinmentDetails(doctor_id,branch_id,date);
        Iterator<Appointment> it=appointments.iterator();
        while (it.hasNext()){
            JSONObject data=new JSONObject();
            Appointment appointment=it.next();
            data.put("stime",appointment.getTime());
            jsonArray.put(data);
        }
        jsonObject.put("schedule_shift",jsonArray);
        return jsonObject.toString();}

    @RequestMapping(value = "ViewAppoinment/{branch_id}/{date}",method = RequestMethod.GET)
    public
    @ResponseBody
    String viewAppoinment(@PathVariable Integer branch_id,@PathVariable String date)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        date=date.replace("-","/");
        List<Appointment> appointments;
        appointments=appointmentService.viewAppoinment(branch_id,date);
        String flag=updateStatus();
        Iterator<Appointment> itr=appointments.iterator();
        while (itr.hasNext()){
            JSONObject data=new JSONObject();
            Appointment appointment= itr.next();
            data.put("appoinment_id",appointment.getAppointment_id());
            data.put("patient_pid",appointment.getPatient_pid());
            data.put("doctor_name",appointment.getDoctor_name());
            data.put("name",appointment.getName());
            data.put("time",appointment.getTime());
            data.put("flag",appointment.getStatus());
            data.put("contact_no",appointment.getContact_no());
            data.put("date",appointment.getDov());
            data.put("status",true);
            jsonArray.put(data);
        }
        jsonObject.put("appoinments",jsonArray);
        return jsonObject.toString();
    }
    @RequestMapping(value = "UpdateScheduleStatus/{status}/{appoinment_id}",method = RequestMethod.POST)
    public
    @ResponseBody
    String updateScheduleStatus(@PathVariable Integer status,@PathVariable Integer appoinment_id)throws JSONException{
        JSONObject jsonObject=new JSONObject();
        boolean flag;
        flag=appointmentService.updateAppoinment(status,appoinment_id);
        jsonObject.put("status",flag);
        return  jsonObject.toString();
    }




   public String updateStatus()throws JSONException{
        JSONObject jsonObject=new JSONObject();
        boolean flag;
        List<Appointment> appointments;
        DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
        HashSet<Integer> appoimentId=new HashSet<Integer>();
        String be_date=sdf.format(new Date());
        appointments=appointmentService.getAppoinment();
        Iterator<Appointment> it=appointments.iterator();
        while (it.hasNext()){
            Appointment appointment=it.next();
            String date=appointment.getDov()+""+appointment.getTime();
            Date dt=new Date(date);
            date=sdf.format(dt);
            Calendar calendar= new GregorianCalendar();
            Calendar calendar1=new GregorianCalendar();
            Date str_date=new Date(date);
            Date end_date=new Date(be_date);
            calendar.setTime(str_date);
            calendar1.setTime(end_date);
            if(!calendar.after(calendar1)){
                if(appointment.getStatus()==0){
                    appoimentId.add(appointment.getAppointment_id());
                }
            }
        }

        flag=appointmentService.setStatus(appoimentId);


        jsonObject.put("status",flag);
        return  jsonObject.toString();

    }



}
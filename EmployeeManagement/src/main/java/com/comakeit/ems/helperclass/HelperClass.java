package com.comakeit.ems.helperclass;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.comakeit.ems.bean.AdminBean;
import com.comakeit.ems.bean.EmpBean;
import com.comakeit.ems.constants.Constants;

@Service
public class HelperClass {

	public String validate(AdminBean adminbean, HttpServletRequest request) {

		RestTemplate rt = new RestTemplate();

		String result = rt.postForObject(Constants.url + "/restlogin/restvalidate", adminbean, String.class);

		return result;
	}

	public EmpBean addemp(EmpBean empbean, AdminBean adminbean) {

		RestTemplate rt = new RestTemplate();

		EmpBean result = rt.postForObject(Constants.url + "/restadd", empbean, EmpBean.class);

		return result;
	}

	public String deleteemp(EmpBean empbean) {

		RestTemplate rt = new RestTemplate();

		  rt.delete(Constants.url + "/restdelete/" + empbean.getEmpid(), String.class);
		 String result= rt.getForObject(Constants.url+"/getstatus", String.class);
		return result;
	}

	public ResponseEntity<List<EmpBean>> listempbyid() {

		RestTemplate rt = new RestTemplate();
		String location = Constants.url + "/restlist/restlistempbyid";

		ResponseEntity<List<EmpBean>> list = rt.exchange(location, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<EmpBean>>() {
				});

		return list;

	}

	public ResponseEntity<List<EmpBean>> listempbydepart() {

		RestTemplate rt = new RestTemplate();
		String location = Constants.url + "/restlist/restlistempbydepart";

		ResponseEntity<List<EmpBean>> x = rt.exchange(location, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<EmpBean>>() {
				});

		return x;

	}

	public List<EmpBean> listempbyreport(EmpBean empbean, HttpServletRequest request) {

		request.getSession().setAttribute("report", empbean.getReportingmanager());

		HttpEntity<EmpBean> requestEntity = new HttpEntity<>(empbean);
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<EmpBean>> response = restTemplate.exchange(Constants.url + "/restlist/restlistempbyreport",
				HttpMethod.POST, requestEntity, new ParameterizedTypeReference<List<EmpBean>>() {
				});
		List<EmpBean> list = response.getBody();

		return list;

	}

	public ResponseEntity<List<EmpBean>> listempwithpf() {

		RestTemplate rt = new RestTemplate();
		String location = Constants.url + "/restlist/restlistempwithpf";

		ResponseEntity<List<EmpBean>> x = rt.exchange(location, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<EmpBean>>() {
				});

		return x;

	}

	public ResponseEntity<List<EmpBean>> listempwithrange() {

		RestTemplate rt = new RestTemplate();
		String location = Constants.url + "/restlist/restlistemprange";

		ResponseEntity<List<EmpBean>> x = rt.exchange(location, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<EmpBean>>() {
				});

		return x;

	}

}

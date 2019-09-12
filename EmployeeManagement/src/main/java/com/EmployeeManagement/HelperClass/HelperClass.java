package com.EmployeeManagement.HelperClass;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.comakeit.ems.bean.AdminBean;
import com.comakeit.ems.bean.EmpBean;

@Service
public class HelperClass {

	@Autowired
	Environment environment;

	public String validate(AdminBean adminbean, HttpServletRequest request) {

		String port = environment.getProperty("local.server.port");
		RestTemplate rt = new RestTemplate();

		String result = rt.postForObject("http://localhost:" + port + "/restlogin/restvalidate", adminbean,
				String.class);

		return result;
	}

	/*
	 * To add an employee which calls restadd in emprestcontroller to perform this
	 * function
	 */
	public EmpBean addemp(EmpBean empbean, AdminBean adminbean) {

		RestTemplate rt = new RestTemplate();
		String port = environment.getProperty("local.server.port");

		EmpBean result = rt.postForObject("http://localhost:" + port + "/restadd", empbean, EmpBean.class);

		return result;
	}

	/*
	 * To delete an employee which calls restdelete in emprestcontroller to perform
	 * this function
	 */
	@RequestMapping(value = "/delete")
	public String deleteemp(EmpBean empbean) {

		RestTemplate rt = new RestTemplate();
		String port = environment.getProperty("local.server.port");

		String result = rt.postForObject("http://localhost:" + port + "/restdelete", empbean, String.class);

		return result;
	}

	/*
	 * To retrieve a list of employee details order by employee id which calls
	 * restlistempbyid in listemprestcontroller to perform this function
	 */
	public ResponseEntity<List<EmpBean>> listempbyid() {

		RestTemplate rt = new RestTemplate();
		String port = environment.getProperty("local.server.port");
		String location = "http://localhost:" + port + "/restlist/restlistempbyid";

		ResponseEntity<List<EmpBean>> x = rt.exchange(location, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<EmpBean>>() {
				});

		return x;

	}

	/*
	 * To retrieve a list of employee details order by department name which calls
	 * restlistempbydepart in listemprestcontroller to perform this function
	 */
	public ResponseEntity<List<EmpBean>> listempbydepart() {

		RestTemplate rt = new RestTemplate();
		String port = environment.getProperty("local.server.port");
		String location = "http://localhost:" + port + "/restlist/restlistempbydepart";

		ResponseEntity<List<EmpBean>> x = rt.exchange(location, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<EmpBean>>() {
				});

		return x;

	}

	/*
	 * To retrieve a list of employee details under a particular manager which calls
	 * restlistempbyreport in listemprestcontroller to perform this function
	 */
	public List<EmpBean> listempbyreport(EmpBean empbean, HttpServletRequest request) {

		request.getSession().setAttribute("report", empbean.getReportingmanager());

		HttpEntity<EmpBean> requestEntity = new HttpEntity<>(empbean);
		RestTemplate restTemplate = new RestTemplate();
		String port = environment.getProperty("local.server.port");

		ResponseEntity<List<EmpBean>> response = restTemplate.exchange(
				"http://localhost:" + port + "/restlist/restlistempbyreport", HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<List<EmpBean>>() {
				});
		List<EmpBean> list = response.getBody();

		return list;

	}

	/*
	 * To retrieve a list of employee details with pf which calls restlistempwithpf
	 * in listemprestcontroller to perform this function
	 */
	public ResponseEntity<List<EmpBean>> listempwithpf() {

		RestTemplate rt = new RestTemplate();
		String port = environment.getProperty("local.server.port");
		String location = "http://localhost:" + port + "/restlist/restlistempwithpf";

		ResponseEntity<List<EmpBean>> x = rt.exchange(location, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<EmpBean>>() {
				});

		return x;

	}

	/*
	 * To retrieve a list of employee details whose salary range between 10000 and
	 * 20000 which calls restlistemprange in listemprestcontroller to perform this
	 * function
	 */
	public ResponseEntity<List<EmpBean>> listempwithrange() {

		RestTemplate rt = new RestTemplate();
		String port = environment.getProperty("local.server.port");
		String location = "http://localhost:" + port + "/restlist/restlistemprange";

		ResponseEntity<List<EmpBean>> x = rt.exchange(location, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<EmpBean>>() {
				});

		return x;

	}

}

package com.vip.saturn.job.console.controller.gui;

import com.vip.saturn.job.console.controller.SuccessResponseEntity;
import com.vip.saturn.job.console.exception.SaturnJobConsoleException;
import com.vip.saturn.job.console.service.JobService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Execution status for specified job.
 *
 * @author kfchu
 */
@Controller
@RequestMapping("/console/job/execution")
public class JobExecutionController {

	@Resource
	private JobService jobService;

	/**
	 * 获取作业执行状态
	 */
	@GetMapping(value = "/status")
	public SuccessResponseEntity getExecutionStatus(final HttpServletRequest request, @RequestParam String namespace,
			@RequestParam String jobName) throws SaturnJobConsoleException {
		return new SuccessResponseEntity(jobService.getExecutionStatus(namespace, jobName));
	}

}

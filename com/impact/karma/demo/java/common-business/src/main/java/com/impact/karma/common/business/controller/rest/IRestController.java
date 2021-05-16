package com.impact.karma.common.business.controller.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.impact.karma.common.business.constant.ReqMapping;
import com.impact.karma.common.business.service.IService;

public interface IRestController<T, ID> {

	public static final String BASE_MAPPING = "/IRestController";

	public IService<T, ID> getService();

	public void setService(IService<T, ID> service);

	@PostMapping(ReqMapping.CREATE)
	public T save(@RequestBody T data);

	@GetMapping(ReqMapping.READ)
	public T findById(@PathVariable(ReqMapping.P_ID) ID id);

	@PutMapping(ReqMapping.UPDATE)
	public T update(@RequestBody T data);

	@DeleteMapping(ReqMapping.DELETE)
	public String delete(@RequestBody T data);

	@PostMapping(ReqMapping.CREATEALL)
	public List<T> createALl(@RequestBody List<T> data);

	@GetMapping(ReqMapping.READALL)
	public List<T> getALl();

	@PutMapping(ReqMapping.UPDATEALL)
	public List<T> updateALl(@RequestBody List<T> data);

	@DeleteMapping(ReqMapping.DELETEALL)
	public String deleteALl(@RequestBody List<T> data);
}

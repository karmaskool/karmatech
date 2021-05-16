package com.impact.karma.common.business.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impact.karma.common.business.constant.Message;
import com.impact.karma.common.business.constant.ReqMapping;
import com.impact.karma.common.business.service.IService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(SimpleRestController.BASE_MAPPING)
@Slf4j
public class SimpleRestController<T, ID> implements IRestController<T, ID> {

	public static final String BASE_MAPPING = "/SimpleRestController";

	@Autowired
	private IService<T, ID> service;

	@Override
	public IService<T, ID> getService() {
		log.info("Calling {} on {}", this.service.getClass().getSimpleName(), this.getClass().getSimpleName());
		return this.service;
	}

	@Override
	public void setService(IService<T, ID> service) {
		this.service =  service;
	}

	@Override
	@PostMapping(ReqMapping.CREATE)
	public T save(@RequestBody T data) {
		return getService().save(data);
	}

	@Override
	@GetMapping(ReqMapping.READ)
	public T findById(@PathVariable(ReqMapping.P_ID) ID id) {
		return getService().findById(id);

	}

	@Override
	@PutMapping(ReqMapping.UPDATE)
	public T update(@RequestBody T data) {
		return getService().update(data);
	}

	@Override
	@DeleteMapping(ReqMapping.DELETE)
	public String delete(@RequestBody T data) {
		getService().delete(data);
		return Message.deletedSuccesfully(data);
	}

	@Override
	@PostMapping(ReqMapping.CREATEALL)
	public List<T> createALl(@RequestBody List<T> data) {
		return getService().saveAll(data);
	}

	@Override
	@GetMapping(ReqMapping.READALL)
	public List<T> getALl() {
		return getService().getAll();
	}

	@Override
	@PutMapping(ReqMapping.UPDATEALL)
	public List<T> updateALl(@RequestBody List<T> data) {
		return getService().saveAll(data);
	}

	@Override
	@DeleteMapping(ReqMapping.DELETEALL)
	public String deleteALl(@RequestBody List<T> data) {
		getService().deleteAll(data);
		return Message.deletedSuccesfully("");
	}
}

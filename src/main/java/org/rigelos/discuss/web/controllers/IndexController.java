package org.rigelos.discuss.web.controllers;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

@Path("/")
public class IndexController extends AbstractCommonController {

	@Get("")
	public String index(Invocation inv){
		return "index";
	}
}

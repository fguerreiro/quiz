package br.unifor.ads.pin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ActionCommand {
	void executeAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}

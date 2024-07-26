package co.edu.uptc.management.callmanagement.rest;

import co.edu.uptc.management.callmanagement.dto.CallDTO;
import co.edu.uptc.management.callmanagement.dto.CallInfo;
import co.edu.uptc.management.callmanagement.enums.ECallType;

import java.util.*;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;



@Path("/ManagementCall")
public class ManagementDTO {

	public static List<CallDTO> callDTOS = new ArrayList<>();
	public static Map<String, CallInfo> callInfo = new HashMap<>();
	public static List<Double> costos = new ArrayList<>();
	public static List<Double> minutos = new ArrayList<>();


	/**
	 * @author monx.voll
	 */


	@POST
	@Path("/addCall")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Boolean createCall(CallDTO callDTO) {
		if(verifyExistence(callDTO.getCallId())) {
			if (getCallDTOS().add(callDTO)) {
				double totalCall = callValueByOperator(callDTO.getCallType(), callDTO.getMinuteValue(), callDTO.getCallDuration());
				callInfo.put(callDTO.getCallId(), new CallInfo(callDTO.getPhoneNumber(), callDTO.getPhoneDestiny(), totalCall));
				return true;
			}
		}
		return false;
	}



	private boolean verifyExistence(String callId){
		for(CallDTO callDTO : getCallDTOS()){
			if(callDTO.getCallId().equals(callId)){
				return false;
			}
		}
		return true;
	}


	@GET
	@Path("/getCallByCode")
	@Produces({MediaType.APPLICATION_JSON})
	public CallInfo getBooksByCode(@QueryParam("ID") String callId) {
		for (CallDTO callDTO : getCallDTOS()) {
			if (callDTO.getCallId().equals(callId)) {
				return callInfo.get(callId);
			}
		}
		return null;
	}


	@GET
	@Path("/getTotalCash")
	@Produces({MediaType.APPLICATION_JSON})
	public Double  getTotalCashByType(@QueryParam("Type") ECallType callType) {
		for(CallDTO callDTO : getCallDTOS()){
			if(callDTO.getCallType()==callType){
				Double totalCost = callInfo.get(callDTO.getCallId()).getTotalCost();
				costos.add(totalCost);
			}
		}
		return finalTotalCost();
	}


	private Double finalTotalCost(){
		Double costosTotalizados = 0.0;

		for (Double costo : getCostos()) {
			costosTotalizados += costo;
		}
		costos.clear();
		return costosTotalizados;
	}


	@GET
	@Path("/getTotalMinutes")
	@Produces({MediaType.APPLICATION_JSON})
	public Double  getTotalMinutesByType(@QueryParam("Type") ECallType callType) {
		for(CallDTO callDTO : getCallDTOS()){
			if(callDTO.getCallType()==callType){
				Double totalCost = callDTO.getCallDuration();
				minutos.add(totalCost);
			}
		}
		return finalTotalMinutes();
	}


	private Double finalTotalMinutes(){
		Double minutosTotalizados = 0.0;

		for (Double minuto : getMinutos()) {
			minutosTotalizados += minuto;
		}
		minutos.clear();
		return minutosTotalizados;
	}


	@POST
	@Path("/getCall")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public CallDTO getCallsByFilter(CallDTO callDTO) {
		CallDTO dataInfoObject = null;
		for (CallDTO callDTO1 : getCallDTOS()) {
			if (!Objects.isNull(callDTO.getCallId())) {
				if(callDTO1.getCallId().equals(callDTO.getCallId())) {
					dataInfoObject = callDTO1;
				}
			} else if (!Objects.isNull(callDTO.getCallType())) {
				if(callDTO1.getCallType().equals(callDTO.getCallType())){
					dataInfoObject = callDTO1;
				}
			} else if (!Objects.isNull(callDTO.getCallDuration())) {
				if(callDTO1.getCallDuration().equals(callDTO.getCallDuration())){
					dataInfoObject = callDTO1;
				}
			} else if (!Objects.isNull(callDTO.getMinuteValue())) {
				if(callDTO1.getMinuteValue().equals(callDTO.getMinuteValue())){
					dataInfoObject = callDTO1;
				}
			} else if (!Objects.isNull(callDTO.getPhoneDestiny())) {
				if(callDTO1.getPhoneDestiny().equals(callDTO.getPhoneDestiny())){
					dataInfoObject = callDTO1;
				}
			} else if (!Objects.isNull(callDTO.getPhoneNumber())) {
				if(callDTO1.getPhoneNumber().equals(callDTO.getPhoneNumber())){
					dataInfoObject = callDTO1;
				}
			}
		}
		return dataInfoObject;
	}


	public double callValueByOperator(ECallType callType, Double minuteValue , Double callDuration){
		Double price = callDuration * minuteValue;
		double excedentPrice;
		double newPrice = 0;
        switch (callType) {
			//Mismo Operador
			case MISMO:
				newPrice = price;
				break;
			//Otro Operador
			case OTRO:
				//20 % de 200 por ejemplo =  20/100 x 200 = 40
				//5 % del precio en este caso
				excedentPrice = (5.0/100.0) * minuteValue;
				newPrice = price + excedentPrice;
				break;
			//Nacional
			case NACIONAL:
				//10 % del precio en este caso
				excedentPrice = (10.0/100.0) * minuteValue;
				newPrice = price + excedentPrice;
				break;
			//Internacional
			case INTERNACIONAL:
				//15 % del precio en este caso
				excedentPrice = (15.0/100.0) * minuteValue;

				newPrice = price + excedentPrice;
				break;
			default:
				System.out.println("Opcion invalida para el tipo de destino ");
				break;
		}
		return newPrice;

	}


	/**
	 * @author monx.voll
	 */


	public List<CallDTO> getCallDTOS() {
		return callDTOS;
	}

	public void setCallDTOS(List<CallDTO> callDTOS) {
		ManagementDTO.callDTOS = callDTOS;
	}

	public static Map<String, CallInfo> getCallInfo() {
		return callInfo;
	}

	public static void setCallInfo(Map<String, CallInfo> callInfo) {
		ManagementDTO.callInfo = callInfo;
	}

	public static List<Double> getCostos() {
		return costos;
	}

	public static void setCostos(List<Double> costos) {
		ManagementDTO.costos = costos;
	}

	public static List<Double> getMinutos() {
		return minutos;
	}

	public static void setMinutos(List<Double> minutos) {
		ManagementDTO.minutos = minutos;
	}
}


package practice.findverma.codehub.design_patterns.structural;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

interface AdditionalRequestParam{
	boolean hasParam(String key);
	String getParam(String key);
	void setParam(String key, String value);
}

class AdditionalRequestParamImpl implements AdditionalRequestParam{
	
	Map<String, String> params = new HashMap<>();

	@Override
	public boolean hasParam(String key) {
		return params.containsKey(key);
	}

	@Override
	public String getParam(String key) {
		return params.get(key);
	}

	@Override
	public void setParam(String key, String value) {
		params.put(key, value);
	}
}

class AdditionalRequestParamDecorator implements AdditionalRequestParam{
	
	AdditionalRequestParam additionRequestParam;	
	Map<String, List<String>> transParams = new HashMap<>();
	
	
	public AdditionalRequestParamDecorator(AdditionalRequestParam additionRequestParam) {
		this.additionRequestParam= additionRequestParam;
	}
	@Override
	public boolean hasParam(String key) {
		return additionRequestParam.hasParam(key);
	}

	@Override
	public String getParam(String key) {
		return additionRequestParam.getParam(key);
	}

	@Override
	public void setParam(String key, String value) {
		additionRequestParam.setParam(key, value);
	}
	
	
	public List<String> getTransParam(String key){
		return transParams.get(key);
	}
	
	public void setTransParam(String key, List<String> values){
		Objects.requireNonNull(values);
		transParams.put(key, Collections.unmodifiableList(new ArrayList<>(values)));
	}
	
	public AdditionalRequestParam getAdditionalRequestParam(){
		return additionRequestParam;
	}
	
}


public class Decorator {

}

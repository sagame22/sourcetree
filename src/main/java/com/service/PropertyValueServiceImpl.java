package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.ProductVO;
import com.property.PropertyDAO;
import com.property.PropertyVO;
import com.propertyvalue.PropertyValueDAO;
import com.propertyvalue.PropertyValueVO;
@Service
public class PropertyValueServiceImpl implements PropertyValueService {
	@Autowired
	private PropertyValueDAO propertyValueDAOImpl;
	@Autowired
	private PropertyDAO propertyDAOImpl;
	@Override
	public void add(PropertyValueVO bean) {
		propertyValueDAOImpl.add(bean);
		
	}

	@Override
	public void update(PropertyValueVO bean) {
		propertyValueDAOImpl.update(bean);
		
	}

	@Override
	public void delete(int id) {
		propertyValueDAOImpl.delete(id);
		
	}

	@Override
	public PropertyValueVO get(int id) {
		PropertyValueVO get = propertyValueDAOImpl.get(id);
		return get;
	}

	@Override
	public PropertyValueVO get(int ptid, int pid) {
		PropertyValueVO get1 = propertyValueDAOImpl.get1(ptid, pid);
		return get1;
	}

	@Override
	public List<PropertyValueVO> list() {
		List<PropertyValueVO> list = propertyValueDAOImpl.list();
		return list;
	}
	

	@Override
	public List<PropertyValueVO> list(int pid) {
		List<PropertyValueVO> list1 = propertyValueDAOImpl.list1(pid);
		return list1;
	}

	@Override
	public void init(ProductVO p) {
		//用產品的CID去查詢對應的屬性值 分類1方-->屬性值和產品為多方
        List<PropertyVO> pts= propertyDAOImpl.list(p.getCategory().getCategoryId());
         
        for (PropertyVO pt: pts) {
        	//用查到的屬性id去查屬性值
            PropertyValueVO pv = get(pt.getPropertyId(),p.getProductId());
            if(null==pv){
            	//第一次沒資料 , 直接把該產品和查出來的屬性(一)  加到屬性值中(多)
                pv = new PropertyValueVO();
                pv.setProduct(p);
                pv.setProperty(pt);
                pv.setValue("");
                this.add(pv);
            }
        }
    }


	public void setPropertyValueDAOImpl(PropertyValueDAO propertyValueDAOImpl) {
		this.propertyValueDAOImpl = propertyValueDAOImpl;
	}

	public void setPropertyDAOImpl(PropertyDAO propertyDAOImpl) {
		this.propertyDAOImpl = propertyDAOImpl;
	}
	
	
	

}

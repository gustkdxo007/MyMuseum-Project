package com.ssafy.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dto.MyArtDto;
import com.ssafy.model.dto.UserDto;
import com.ssafy.model.repository.MyArtRepository;
import com.ssafy.model.repository.UserRepository;

@Service
public class MyArtServiceImpl implements MyArtService {
	@Autowired
	private MyArtRepository myartReponsitory;
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserDto> findArtistList(int start) {
		// TODO Auto-generated method stub
		int index = 16 * start;

		List<UserDto> list = userRepository.findMyArtist(index);

		for (int i = 0; i < list.size(); i++)
			list.get(i).setUserPassword("");

		return list;
	}

	@Override
	public MyArtDto saveMyart(MyArtDto myart) {
		// TODO Auto-generated method stub
		return myartReponsitory.save(myart);
	}

	@Override
	public List<MyArtDto> findMyArtByUserID(String userId, int start) {
		// TODO Auto-generated method stub
		int index = 16 * start;

		return myartReponsitory.findByUserId(userId, index);
	}

	@Override
	public MyArtDto findMyArtDetail(int myartNo) {
		Optional<MyArtDto> myart = myartReponsitory.findMyartDetail(myartNo);

		if (myart.isPresent())
			return myart.get();
		else
			return null;
	}

}

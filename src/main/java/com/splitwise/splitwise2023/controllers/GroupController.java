package com.splitwise.splitwise2023.controllers;

import com.splitwise.splitwise2023.dtos.CreateGroupRequestDto;
import com.splitwise.splitwise2023.dtos.CreateGroupResponseDto;
import com.splitwise.splitwise2023.services.group.GroupService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
public class GroupController {
    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    public CreateGroupResponseDto createGroup(CreateGroupRequestDto requestDto)
    {
        CreateGroupResponseDto responseDto = new CreateGroupResponseDto();
        responseDto.setGroup(this.groupService.createGroup(requestDto.getName(), requestDto.getCreatedByUserId(),
                requestDto.getDescription()));
        return responseDto;
    }
}

package com.splitwise.splitwise2023.services.group;

import com.splitwise.splitwise2023.models.Group;
import com.splitwise.splitwise2023.repositories.GroupRepository;
import com.splitwise.splitwise2023.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {
    private GroupRepository groupRepository;
    private UserRepository userRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository, UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    public Group createGroup(String name, Long createByUserId, String description)
    {
        Group group = new Group();
        group.setName(name);
        group.setCreatedBy(userRepository.findById(createByUserId).get());
        group.setDescription(description);

        return  this.groupRepository.save(group);
    }
}

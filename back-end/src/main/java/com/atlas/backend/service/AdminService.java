package com.atlas.backend.service;

import com.atlas.backend.model.Admin;
import com.atlas.backend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // Create or update admin
    public Admin saveAdmin(Admin admin) {
        if (admin.getId() == null) {
            admin.setCreatedAt(LocalDateTime.now());
        }
        return adminRepository.save(admin);
    }

    // Get all admins
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    // Get admin by ID
    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    // Get admin by username
    public Optional<Admin> getAdminByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    // Get admin by email
    public Optional<Admin> getAdminByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    // Delete admin
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    // Check if admin exists
    public boolean adminExists(Long id) {
        return adminRepository.existsById(id);
    }

    // Check if username exists
    public boolean usernameExists(String username) {
        return adminRepository.existsByUsername(username);
    }

    // Check if email exists
    public boolean emailExists(String email) {
        return adminRepository.existsByEmail(email);
    }
}


package com.example.jwtauth.Service;
import com.example.jwtauth.DAO.ThemeRepository;
import com.example.jwtauth.Entity.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThemeService {

    @Autowired
    private ThemeRepository themeRepository;

    public List<Theme> getAllThemes() {
        return themeRepository.findAll();
    }

    public Optional<Theme> getThemeById(Long id) {
        return themeRepository.findById(id);
    }

    public Theme createTheme(Theme theme) {
        return themeRepository.save(theme);
    }

    public Theme updateTheme(Long id, Theme themeDetails) {
        Theme theme = themeRepository.findById(id).orElseThrow(() -> new RuntimeException("Theme not found"));
        theme.setCode(themeDetails.getCode());
        theme.setTheme(themeDetails.getTheme());
        theme.setNbrCandidat(themeDetails.getNbrCandidat());
        theme.setNbrGroupes(themeDetails.getNbrGroupes());
        theme.setNGroupe(themeDetails.getNGroupe());
        theme.setDuree(themeDetails.getDuree());
        theme.setDateDebut(themeDetails.getDateDebut());
        theme.setDateFin(themeDetails.getDateFin());
        theme.setFormateur(themeDetails.getFormateur());
        return themeRepository.save(theme);
    }

    public void deleteTheme(Long id) {
        Theme theme = themeRepository.findById(id).orElseThrow(() -> new RuntimeException("Theme not found"));
        themeRepository.delete(theme);
    }
}

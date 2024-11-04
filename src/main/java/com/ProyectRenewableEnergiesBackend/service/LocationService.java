package com.ProyectRenewableEnergiesBackend.service;

import com.ProyectRenewableEnergiesBackend.model.Location;
import com.ProyectRenewableEnergiesBackend.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    private Map<String, String> countryRegionMap;

    public LocationService(Map<String, String> countryRegionMap) {
        this.countryRegionMap = countryRegionMap;
        loadRegion();
    }

    public Location add(Location location) {
       if(!existsByNameAndYear(location.getName(), location.getYear())) {
            location.setRegion(
                    countryRegionMap.getOrDefault(
                            location.getName(), null
                    )
            );
            return locationRepository.save(location);
        }
        return null;
    }

    public List<Location> getAll() {
        return locationRepository.findAll();
    }

    public Optional<Location> getById(int id) {
        return locationRepository.findById(id);
    }

    public Location updateById(int id, Location location) {
        return locationRepository.findById(id)
                .map(oldLocation -> {
                    if (location.getName() != null) {
                        oldLocation.setName(location.getName());
                    }
                    if (location.getYear() != null) {
                        oldLocation.setYear(location.getYear());
                    }
                    return locationRepository.save(oldLocation);
                })
                .orElseThrow(() -> new RuntimeException("Location with id " + id + " not found"));
    }

    public void deleteById(int id) {
        locationRepository.deleteById(id);
    }

    public boolean existsByNameAndYear(String name, Integer year) {
        return locationRepository.existsByNameAndYear(name, year);
    }

    public Optional<Location> getLocationsByNameAndYear(String name, Integer year) {
        return locationRepository.findByNameAndYear(name, year);
    }

    public long getCount() {
        return locationRepository.count();
    }

    public void loadRegion(){
        countryRegionMap.put("Afghanistan", "Asia del Sur");
        countryRegionMap.put("Albania", "Europa del Sur");
        countryRegionMap.put("Germany", "Europa Occidental");
        countryRegionMap.put("Andorra", "Europa del Sur");
        countryRegionMap.put("Angola", "África Austral");
        countryRegionMap.put("Antigua y Barbuda", "Caribe");
        countryRegionMap.put("Saudi Arabia", "Asia Occidental");
        countryRegionMap.put("Argelia", "Norte de África");
        countryRegionMap.put("Argentina", "América del Sur");
        countryRegionMap.put("Armenia", "Asia Occidental");
        countryRegionMap.put("Australia", "Oceanía");
        countryRegionMap.put("Austria", "Europa Occidental");
        countryRegionMap.put("Azerbaijan", "Asia Occidental");
        countryRegionMap.put("Bahamas", "Caribe");
        countryRegionMap.put("Bahrain", "Asia Occidental");
        countryRegionMap.put("Bangladesh", "Asia del Sur");
        countryRegionMap.put("Barbados", "Caribe");
        countryRegionMap.put("Belgium", "Europa Occidental");
        countryRegionMap.put("Belize", "América Central");
        countryRegionMap.put("Benín", "África Occidental");
        countryRegionMap.put("Belarus", "Europa del Este");
        countryRegionMap.put("Bolivia", "América del Sur");
        countryRegionMap.put("Bosnia y Herzegovina", "Europa del Sur");
        countryRegionMap.put("Botswana", "África Austral");
        countryRegionMap.put("Brazil", "América del Sur");
        countryRegionMap.put("Brunéi", "Asia del Sudeste");
        countryRegionMap.put("Bulgaria", "Europa del Este");
        countryRegionMap.put("Burkina Faso", "África Occidental");
        countryRegionMap.put("Burundi", "África Oriental");
        countryRegionMap.put("Cabo Verde", "África Occidental");
        countryRegionMap.put("Cameroon", "África Central");
        countryRegionMap.put("Canada", "América del Norte");
        countryRegionMap.put("Chile", "América del Sur");
        countryRegionMap.put("China", "Asia Oriental");
        countryRegionMap.put("Cyprus", "Europa del Este");
        countryRegionMap.put("Colombia", "América del Sur");
        countryRegionMap.put("Comoros", "África Oriental");
        countryRegionMap.put("Congo (República del)", "África Central");
        countryRegionMap.put("Congo (República Democrática del)", "África Central");
        countryRegionMap.put("Costa Rica", "América Central");
        countryRegionMap.put("Croatia", "Europa del Sur");
        countryRegionMap.put("Cuba", "Caribe");
        countryRegionMap.put("Denmark", "Europa del Norte");
        countryRegionMap.put("Dominica", "Caribe");
        countryRegionMap.put("Ecuador", "América del Sur");
        countryRegionMap.put("Egypt", "Norte de África");
        countryRegionMap.put("El Salvador", "América Central");
        countryRegionMap.put("United Arab Emirates", "Asia Occidental");
        countryRegionMap.put("Slovenia", "Europa del Sur");
        countryRegionMap.put("Spain", "Europa del Sur");
        countryRegionMap.put("United States", "América del Norte");
        countryRegionMap.put("Estonia", "Europa del Norte");
        countryRegionMap.put("Eswatini", "África Austral");
        countryRegionMap.put("Ethiopia", "África Oriental");
        countryRegionMap.put("Philippines", "Asia del Sudeste");
        countryRegionMap.put("Finland", "Europa del Norte");
        countryRegionMap.put("France", "Europa Occidental");
        countryRegionMap.put("Gabón", "África Central");
        countryRegionMap.put("Gambia", "África Occidental");
        countryRegionMap.put("Georgia", "Asia Occidental");
        countryRegionMap.put("Ghana", "África Occidental");
        countryRegionMap.put("Greece", "Europa del Sur");
        countryRegionMap.put("Guatemala", "América Central");
        countryRegionMap.put("Guinea", "África Occidental");
        countryRegionMap.put("Guinea Ecuatorial", "África Central");
        countryRegionMap.put("Guyana", "América del Sur");
        countryRegionMap.put("Haití", "Caribe");
        countryRegionMap.put("Holland", "Europa Occidental");
        countryRegionMap.put("Hungary", "Europa del Este");
        countryRegionMap.put("Hong Kong", "Asia Oriental");
        countryRegionMap.put("India", "Asia del Sur");
        countryRegionMap.put("Indonesia", "Asia del Sudeste");
        countryRegionMap.put("Iraq", "Asia Occidental");
        countryRegionMap.put("Iran", "Asia Occidental");
        countryRegionMap.put("Ireland", "Europa del Norte");
        countryRegionMap.put("Iceland", "Europa del Norte");
        countryRegionMap.put("Solomon Islands", "Oceanía");
        countryRegionMap.put("Israel", "Asia Occidental");
        countryRegionMap.put("Italy", "Europa del Sur");
        countryRegionMap.put("Jamaica", "Caribe");
        countryRegionMap.put("Japan", "Asia Oriental");
        countryRegionMap.put("Jordan", "Asia Occidental");
        countryRegionMap.put("Kazakhstan", "Asia Central");
        countryRegionMap.put("Kenia", "África Oriental");
        countryRegionMap.put("Kyrgyzstan", "Asia Central");
        countryRegionMap.put("Kiribati", "Oceanía");
        countryRegionMap.put("Kuwait", "Asia Occidental");
        countryRegionMap.put("Laos", "Asia del Sudeste");
        countryRegionMap.put("Lesotho", "África Austral");
        countryRegionMap.put("Latvia", "Europa del Norte");
        countryRegionMap.put("Lebanon", "Asia Occidental");
        countryRegionMap.put("Liberia", "África Occidental");
        countryRegionMap.put("Libya", "Norte de África");
        countryRegionMap.put("Liechtenstein", "Europa Occidental");
        countryRegionMap.put("Lithuania", "Europa del Norte");
        countryRegionMap.put("Luxembourg", "Europa Occidental");
        countryRegionMap.put("Malaysia", "Asia del Sudeste");
        countryRegionMap.put("Malawi", "África Austral");
        countryRegionMap.put("Maldives", "Asia del Sur");
        countryRegionMap.put("Malta", "Europa del Sur");
        countryRegionMap.put("Mali", "África Occidental");
        countryRegionMap.put("Morocco", "Norte de África");
        countryRegionMap.put("Mauricio", "África Oriental");
        countryRegionMap.put("Mauritania", "África Occidental");
        countryRegionMap.put("Mexico", "América del Norte");
        countryRegionMap.put("Micronesia", "Oceanía");
        countryRegionMap.put("Moldavia", "Europa del Este");
        countryRegionMap.put("Mónaco", "Europa del Sur");
        countryRegionMap.put("Mongolia", "Asia Oriental");
        countryRegionMap.put("Mozambique", "África Austral");
        countryRegionMap.put("Namibia", "África Austral");
        countryRegionMap.put("Nepal", "Asia del Sur");
        countryRegionMap.put("Nicaragua", "América Central");
        countryRegionMap.put("Nigeria", "África Occidental");
        countryRegionMap.put("Netherlands", "Europa del Norte");
        countryRegionMap.put("New Zealand", "Oceanía");
        countryRegionMap.put("North Macedonia", "Europa del Sur");
        countryRegionMap.put("Norway", "Europa del Norte");
        countryRegionMap.put("Oman", "Asia Occidental");
        countryRegionMap.put("Panamá", "América Central");
        countryRegionMap.put("Papúa Nueva Guinea", "Oceanía");
        countryRegionMap.put("Paraguay", "América del Sur");
        countryRegionMap.put("Peru", "América del Sur");
        countryRegionMap.put("Poland", "Europa del Este");
        countryRegionMap.put("Portugal", "Europa del Sur");
        countryRegionMap.put("Pakistan", "Asia del Sur");
        countryRegionMap.put("Qatar", "Asia Occidental");
        countryRegionMap.put("United Kingdom", "Europa Occidental");
        countryRegionMap.put("Central African Republic", "África Central");
        countryRegionMap.put("Czechia", "Europa del Este");
        countryRegionMap.put("Dominican Republic", "Caribe");
        countryRegionMap.put("Romania", "Europa del Este");
        countryRegionMap.put("Russia", "Europa del Este");
        countryRegionMap.put("Rwanda", "África Oriental");
        countryRegionMap.put("Saint Kitts and Nevis", "Caribe");
        countryRegionMap.put("San Marino", "Europa del Sur");
        countryRegionMap.put("Santa Lucía", "Caribe");
        countryRegionMap.put("Santo Tomé y Príncipe", "África Central");
        countryRegionMap.put("Senegal", "África Occidental");
        countryRegionMap.put("Serbia", "Europa del Este");
        countryRegionMap.put("Seychelles", "África Oriental");
        countryRegionMap.put("Singapore", "Asia del Sudeste");
        countryRegionMap.put("Syria", "Asia Occidental");
        countryRegionMap.put("South Africa", "África Austral");
        countryRegionMap.put("Sudán", "Norte de África");
        countryRegionMap.put("Sudán del Sur", "África Oriental");
        countryRegionMap.put("Sweden", "Europa del Norte");
        countryRegionMap.put("Suiza", "Europa Occidental");
        countryRegionMap.put("Tailandia", "Asia del Sudeste");
        countryRegionMap.put("Tanzania", "África Oriental");
        countryRegionMap.put("Timor Oriental", "Asia del Sudeste");
        countryRegionMap.put("Togo", "África Occidental");
        countryRegionMap.put("Tonga", "Oceanía");
        countryRegionMap.put("Trinidad y Tobago", "Caribe");
        countryRegionMap.put("Tunisia", "Norte de África");
        countryRegionMap.put("Turkmenistán", "Asia Central");
        countryRegionMap.put("Türkiye", "Asia Occidental");
        countryRegionMap.put("Tuvalu", "Oceanía");
        countryRegionMap.put("Uganda", "África Oriental");
        countryRegionMap.put("Ukraine", "Europa del Este");
        countryRegionMap.put("Uruguay", "América del Sur");
        countryRegionMap.put("Uzbekistán", "Asia Central");
        countryRegionMap.put("Vanuatu", "Oceanía");
        countryRegionMap.put("Vatican", "Europa del Sur");
        countryRegionMap.put("Venezuela", "América del Sur");
        countryRegionMap.put("Vietnam", "Asia del Sudeste");
        countryRegionMap.put("Yemen", "Asia Occidental");
        countryRegionMap.put("Zambia", "África Austral");
        countryRegionMap.put("Zimbabwe", "África Austral");
    }
}

package peaksoft.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.CompanyRequest;
import peaksoft.dto.response.CompanyResponse;
import peaksoft.dto.SimpleResponse;
import peaksoft.entity.Company;
import peaksoft.exception.InvalidNameException;
import peaksoft.repasitory.CompanyRepository;
import peaksoft.service.CompanyService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor

public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public SimpleResponse saveCompany(CompanyRequest companyRequest) {
        Company company1 = companyRepository.findCompanyByName(companyRequest.getName());
        if (company1 == null) {
            Company company = new Company();
            company.setName(companyRequest.getName());
            company.setCountry(companyRequest.getCountry());
            company.setAddress(companyRequest.getAddress());
            company.setPhoneNumber(companyRequest.getPhoneNumber());
            companyRepository.save(company);
            return SimpleResponse.builder()
                    .httpStatus(HttpStatus.OK)
                    .message(String.format("Company with id: %s successfully saved", company.getId())).build();
        } else {
            throw new InvalidNameException(String.format("Компания с таким именем: %s уже существует", companyRequest.getName()));
        }
    }

    @Override
    public List<CompanyResponse> getAllCompanies() {
        return companyRepository.getAllCompanies();
    }

    @Override
    public CompanyResponse getCompanyById(Long id) {
        return companyRepository.getCompanyById(id).orElseThrow(
                () -> new NullPointerException(
                        "Company with id " + id + " is not found!"
                )
        );
    }

    @Override
    public SimpleResponse updateCompany(Long id, CompanyRequest companyRequest) {
        Company company = companyRepository.findById(id).orElseThrow(
                () -> new NullPointerException(
                        "Company with id " + id + " is not found!"));

        company.setName(companyRequest.getName());
        company.setCountry(companyRequest.getCountry());
        company.setAddress(companyRequest.getAddress());
        company.setPhoneNumber(companyRequest.getPhoneNumber());

        companyRepository.save(company);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message(String.format("Company with id: %s successfully updated", company.getId()))
                .build();
    }

    @Override
    public SimpleResponse deleteCompany(Long id) {
        if (!companyRepository.existsById(id)) {
            throw new NullPointerException(
                    "Company with id: " + id + " is not found!");
        }
        companyRepository.deleteById(id);
        return new SimpleResponse(
                HttpStatus.OK,
                "Company with id: " + id + " is deleted!");
    }
}

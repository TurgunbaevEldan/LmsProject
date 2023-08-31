package peaksoft.service;

import peaksoft.dto.request.CompanyRequest;
import peaksoft.dto.response.CompanyResponse;
import peaksoft.dto.SimpleResponse;

import java.util.List;

public interface CompanyService {
    SimpleResponse saveCompany(CompanyRequest companyRequest);
    List<CompanyResponse>getAllCompanies();
    CompanyResponse getCompanyById(Long id);
    SimpleResponse updateCompany(Long id,CompanyRequest companyRequest);
    SimpleResponse deleteCompany(Long id);

}

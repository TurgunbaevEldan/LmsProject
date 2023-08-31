package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.CompanyRequest;
import peaksoft.dto.response.CompanyResponse;
import peaksoft.dto.SimpleResponse;
import peaksoft.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class CompanyApi {

    private final CompanyService companyService;

    @GetMapping
    public List<CompanyResponse> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @PostMapping
    public SimpleResponse saveCompany(@RequestBody CompanyRequest companyRequest) {
        return companyService.saveCompany(companyRequest);
    }

    @GetMapping("/{companyId}")
    public CompanyResponse getById(@PathVariable Long companyId) {
        return companyService.getCompanyById(companyId);
    }

    @PutMapping("/{companyId}")
    public SimpleResponse updateCompany(@PathVariable Long companyId,
                                        @RequestBody CompanyRequest companyRequest) {
        return companyService.updateCompany(companyId, companyRequest);
    }

    @DeleteMapping("/{companyId}")
    public SimpleResponse deleteCompany(@PathVariable Long companyId) {
        return companyService.deleteCompany(companyId);
    }
}

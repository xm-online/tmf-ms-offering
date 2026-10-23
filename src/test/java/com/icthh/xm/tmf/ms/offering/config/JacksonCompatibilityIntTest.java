package com.icthh.xm.tmf.ms.offering.config;

import static org.assertj.core.api.Assertions.assertThat;

import com.icthh.xm.tmf.ms.offering.AbstractSpringBootTest;
import com.icthh.xm.tmf.ms.offering.web.api.model.Category;
import com.icthh.xm.tmf.ms.offering.web.api.model.CategoryCreate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tools.jackson.databind.json.JsonMapper;

/**
 * Request and response JSON must stay as it was with Jackson 2 / openapi-generator 4.2.2: properties in
 * declaration order, unset properties and collections written as null, absent fields left unset.
 */
public class JacksonCompatibilityIntTest extends AbstractSpringBootTest {

    @Autowired
    private JsonMapper jsonMapper;

    @Test
    public void modelKeepsDeclarationOrderAndNulls() {
        Category category = new Category();
        category.setId("1");
        category.setName("n");

        assertThat(jsonMapper.writeValueAsString(category)).isEqualTo("{\"id\":\"1\",\"href\":null,\"price\":null,"
            + "\"description\":null,\"isRoot\":null,\"lastUpdate\":null,\"lifecycleStatus\":null,\"name\":\"n\","
            + "\"parentId\":null,\"version\":null,\"productOffering\":null,\"subCategory\":null,\"validFor\":null,"
            + "\"@baseType\":null,\"@schemaLocation\":null,\"@type\":null}");
    }

    @Test
    public void absentFieldsStayUnset() {
        CategoryCreate request = jsonMapper.readValue("{\"name\":\"x\",\"unknown\":1}", CategoryCreate.class);

        assertThat(request.getName()).isEqualTo("x");
        assertThat(request.getProductOffering()).isNull();
        assertThat(request.getSubCategory()).isNull();
    }
}

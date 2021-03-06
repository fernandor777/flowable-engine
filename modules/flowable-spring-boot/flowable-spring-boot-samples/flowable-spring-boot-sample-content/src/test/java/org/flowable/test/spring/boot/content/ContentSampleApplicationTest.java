/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.flowable.test.spring.boot.content;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.flowable.content.api.ContentItem;
import org.flowable.content.api.ContentService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import flowable.ContentSampleApplication;

/**
 * @author Filip Hrisafov
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContentSampleApplication.class)
public class ContentSampleApplicationTest {

    @Autowired
    private ContentService contentService;

    @Autowired
    private RuntimeService runtimeService;

    @Test
    public void contextLoads() {

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("waiter");

        ContentItem contentItem = contentService.newContentItem();
        contentItem.setName("testContent.txt");
        contentItem.setMimeType("text/plain");
        contentItem.setProcessInstanceId(processInstance.getProcessInstanceId());

        contentService.saveContentItem(contentItem, new ByteArrayInputStream("Test input".getBytes()));

        InputStream contentItemData = contentService.getContentItemData(contentItem.getId());

        assertThat(contentItemData).hasSameContentAs(new ByteArrayInputStream("Test input".getBytes()));
    }
}

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
package org.flowable.job.service.impl.persistence.entity;

import java.util.Date;

import org.flowable.common.engine.impl.db.HasRevision;
import org.flowable.common.engine.impl.persistence.entity.Entity;

/**
 * @author Tijs Rademakers
 * @author Joram Barrez
 */
public interface AbstractJobEntity extends Entity, HasRevision {

    void setRetries(int retries);

    void setJobHandlerType(String jobHandlerType);

    void setJobHandlerConfiguration(String jobHandlerConfiguration);

    String getCustomValues();

    void setCustomValues(String customValues);

    JobByteArrayRef getCustomValuesByteArrayRef();

    String getExceptionStacktrace();

    void setExceptionStacktrace(String exception);

    void setExceptionMessage(String exceptionMessage);

    JobByteArrayRef getExceptionByteArrayRef();

    void setTenantId(String tenantId);

    Date getCreateTime();

}

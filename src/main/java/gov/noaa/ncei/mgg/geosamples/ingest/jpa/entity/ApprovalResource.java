package gov.noaa.ncei.mgg.geosamples.ingest.jpa.entity;

import edu.colorado.cires.cmg.jpa.model.EntityWithId;
import java.io.Serializable;

public interface ApprovalResource<I extends Serializable> extends EntityWithId<I> {
  GeosamplesApprovalEntity getApproval();
  void setApproval(GeosamplesApprovalEntity approval);

  boolean isPublish();
  void setPublish(boolean publish);
}

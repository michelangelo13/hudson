package hudson.views;

import net.sf.json.JSONObject;

import org.kohsuke.stapler.StaplerRequest;

import hudson.Extension;
import hudson.model.Descriptor;
import hudson.model.Descriptor.FormException;
import hudson.views.StatusColumn.DescriptorImpl;

public class BuildButtonColumn extends ListViewColumn {

    public Descriptor<ListViewColumn> getDescriptor() {
        return DESCRIPTOR;
    }
    
    public static final Descriptor<ListViewColumn> DESCRIPTOR = new DescriptorImpl();

    @Extension
    public static class DescriptorImpl extends Descriptor<ListViewColumn> {
        @Override
        public ListViewColumn newInstance(StaplerRequest req, JSONObject formData) throws FormException {
            // This will be called with req == null also the Descriptor's doc tells you not. so the default impl fails
            return new BuildButtonColumn();
        }

        @Override
        public String getDisplayName() {
            return "Build Button";
        }
    }
}
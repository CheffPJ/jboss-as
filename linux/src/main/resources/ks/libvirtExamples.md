sudo virt-install \
--noautoconsole \
--name=as7-02 \
--disk /var/lib/libvirt/images/as7-02.img,size=5 \
--vcpus=1 \
--ram=1024 \
--location="http://download.fedoraproject.org/pub/fedora/linux/releases/15/Fedora/x86_64/os"
--os-type=linux \
--os-variant=fedora14 \
--extra-args="ks=https://raw.github.com/CheffPJ/jboss-as/linux_init/linux/src/main/resources/ks/base-ks.cfg"

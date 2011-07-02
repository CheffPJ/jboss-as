sudo virt-install \
--noautoconsole \
--name=as7-02 \
--disk /var/lib/libvirt/images/as7-02.img,size=5 \
--vcpus=1 \
--ram=1024 \
--location=http://192.168.122.1/trees/fedora14 \
--os-type=linux \
--os-variant=fedora14 \
--extra-args="ks=http://192.168.122.1/ks/fedora14-base-vm.ks"

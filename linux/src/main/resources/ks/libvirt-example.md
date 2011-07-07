> wget -P /tmp http://download.fedoraproject.org/pub/fedora/linux/releases/15/Fedora/x86_64/os/images/boot.iso

> export IMG_MOUNT=/tmp/f15-boot

> sudo mkdir $IMG_MOUNT

> sudo mount -o loop /tmp/boot.iso $IMG_MOUNT

> sudo virt-install --location=$IMG_MOUNT --name=as7-02 --disk /var/lib/libvirt/images/as7-02.img,size=5 --network network=jboss1 --vcpus=1 --ram=1024 --os-type=linux --os-variant=fedora14 --extra-args="ks=//http://people.redhat.com/~pmcdonou/src/jboss-as7-linux/lovelock-white-rabbit-ks.cfg"
